package org.cfw.biz.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.cfw.biz.service.LoginService;
import org.cfw.biz.sys.dao.SysAccountMapper;
import org.cfw.biz.sys.model.SysAccount;
import org.cfw.biz.sys.model.SysModuledef;
import org.cfw.common.CachedVOUtil;
import org.cfw.common.vo.MenuVO;

public class LoginServiceImpl implements LoginService {

    private SysAccountMapper sysAccountMapper;

    public List<MenuVO> constructMenu() {
        List<MenuVO> menuList = constructMainMenu();
        for (MenuVO vo : menuList) {
            vo.setMenus(constructSubMenu(vo.getModuleid()));
        }
        return menuList;
    }

    private List<MenuVO> constructMainMenu() {
        List<MenuVO> menuList = new ArrayList<MenuVO>();
        List<SysModuledef> moduledefList = CachedVOUtil.getModuledefList();
        for (SysModuledef moduledef : moduledefList) {
            if (moduledef.getParentmoduleid().equals(moduledef.getModuleid())) {
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

    private List<MenuVO> constructSubMenu(String moduleid) {
        List<MenuVO> menuList = new ArrayList<MenuVO>();
        List<SysModuledef> moduledefList = CachedVOUtil.getModuledefList();
        for (SysModuledef moduledef : moduledefList) {
            if (!moduledef.getParentmoduleid().equals(moduledef.getModuleid())
                && moduledef.getParentmoduleid().equals(moduleid)) {
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

    public SysAccount selectByAccount(String account) {
        return sysAccountMapper.selectByPrimaryKey(account);
    }

    public void setSysAccountMapper(SysAccountMapper sysAccountMapper) {
        this.sysAccountMapper = sysAccountMapper;
    }

}
