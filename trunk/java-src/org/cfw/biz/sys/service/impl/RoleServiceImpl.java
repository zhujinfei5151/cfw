package org.cfw.biz.sys.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.cfw.biz.sys.dao.SysRoleMapper;
import org.cfw.biz.sys.model.SysModuledef;
import org.cfw.biz.sys.model.SysRole;
import org.cfw.biz.sys.service.RoleService;
import org.cfw.common.CachedVOUtil;
import org.cfw.common.vo.MenuVO;

public class RoleServiceImpl implements RoleService {

    private SysRoleMapper sysRoleMapper;

    public List<SysRole> query() {
        return sysRoleMapper.selectByExample(null);
    }

    public List<MenuVO> menu() {
        List<MenuVO> menuList = new ArrayList<MenuVO>();
        List<SysModuledef> moduledefList = CachedVOUtil.getModuledefList();
        for (SysModuledef moduledef : moduledefList) {
            MenuVO vo = new MenuVO();
            String moduleid = moduledef.getModuleid();
            StringBuffer text = new StringBuffer();
            if (moduleid.indexOf("000000") > 0) {
                text.append("├ ");
            } else if (moduleid.indexOf("0000") > 0) {
                text.append("├── ");
            } else if (moduleid.indexOf("00") > 0) {
                text.append("├──── ");
            }
            text.append(moduledef.getName());
            vo.setText(text.toString());
            vo.setIconCls(moduledef.getIcon());
            vo.setModuleid(moduleid);
            vo.setUrl(moduledef.getUrl());
            menuList.add(vo);
        }
        return menuList;
    }

    public void setSysRoleMapper(SysRoleMapper sysRoleMapper) {
        this.sysRoleMapper = sysRoleMapper;
    }

}
