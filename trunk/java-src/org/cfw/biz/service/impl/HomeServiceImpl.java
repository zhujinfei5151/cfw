package org.cfw.biz.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.cfw.biz.service.HomeService;
import org.cfw.biz.sys.model.SysModuledef;
import org.cfw.common.CachedVOUtil;
import org.cfw.common.Constants;
import org.cfw.common.vo.MenuVO;
import org.cfw.common.vo.ModulePermitVO;

public class HomeServiceImpl implements HomeService {

    public List<MenuVO> constructMenu(List<ModulePermitVO> moduleList) throws IOException {
        String clientTech = CachedVOUtil.getSysParam(Constants.CLIENT_TECH);// 客户端使用技术
        List<MenuVO> menuList = constructMainMenu(moduleList);
        for (MenuVO vo : menuList) {
            if (isExistModule(moduleList, vo.getModuleid())) {
                if (clientTech.equals("1")) {// Extjs
                    vo.setMenus(constructSubMenu(vo.getModuleid(), moduleList));
                } else {// Flex
                    vo.setChildren(constructSubMenu(vo.getModuleid(), moduleList));
                }
            }
        }
        return menuList;
    }

    private List<MenuVO> constructMainMenu(List<ModulePermitVO> moduleList) {
        List<MenuVO> menuList = new ArrayList<MenuVO>();
        List<SysModuledef> moduledefList = CachedVOUtil.getModuledefList();
        for (SysModuledef moduledef : moduledefList) {
            if (moduledef.getParentmoduleid().equals(moduledef.getModuleid())
                && isExistModule(moduleList, moduledef.getModuleid())) {
                MenuVO vo = new MenuVO();
                vo.setText(moduledef.getName());
                vo.setIconCls(moduledef.getIcon());
                vo.setModuleid(moduledef.getModuleid());
                vo.setUrl(moduledef.getUrl());
                menuList.add(vo);
            }
        }
        return menuList;
    }

    public List<MenuVO> constructSubMenu(String moduleid, List<ModulePermitVO> moduleList) {
        List<MenuVO> menuList = new ArrayList<MenuVO>();
        List<SysModuledef> moduledefList = CachedVOUtil.getModuledefList();
        for (SysModuledef moduledef : moduledefList) {
            if (!moduledef.getParentmoduleid().equals(moduledef.getModuleid())
                && moduledef.getParentmoduleid().equals(moduleid) && isExistModule(moduleList, moduledef.getModuleid())) {
                MenuVO vo = new MenuVO();
                vo.setText(moduledef.getName());
                vo.setIconCls(moduledef.getIcon());
                vo.setModuleid(moduledef.getModuleid());
                vo.setUrl(moduledef.getUrl());
                vo.setLeaf(true);
                menuList.add(vo);
            }
        }
        return menuList;
    }

    public List<MenuVO> constructTabs(String moduleid, List<ModulePermitVO> moduleList) {
        List<MenuVO> menuList = new ArrayList<MenuVO>();
        List<SysModuledef> moduledefList = CachedVOUtil.getModuledefList();
        for (SysModuledef moduledef : moduledefList) {
            if (!moduledef.getParentmoduleid().equals(moduledef.getModuleid())
                && moduledef.getParentmoduleid().equals(moduleid) && isExistModule(moduleList, moduledef.getModuleid())) {
                MenuVO vo = new MenuVO();
                vo.setText(moduledef.getName());
                vo.setIconCls(moduledef.getIcon());
                vo.setModuleid(moduledef.getModuleid());
                vo.setUrl(moduledef.getUrl());
                menuList.add(vo);
            }
        }
        return menuList;
    }

    private boolean isExistModule(List<ModulePermitVO> moduleList, String moduleid) {
        if (moduleList == null) return true;
        for (ModulePermitVO vo : moduleList) {
            if (vo.getModuleid().equals(moduleid) && vo.getMask() > 0) return true;
        }
        return false;
    }
}
