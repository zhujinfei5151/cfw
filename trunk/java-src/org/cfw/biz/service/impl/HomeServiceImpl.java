package org.cfw.biz.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.cfw.biz.service.HomeService;
import org.cfw.biz.sys.model.SysModuledef;
import org.cfw.common.CachedVOUtil;
import org.cfw.common.vo.MenuVO;

public class HomeServiceImpl implements HomeService {

    public List<MenuVO> constructTabs(String moduleid) {
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
}
