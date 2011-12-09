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

    public void insertRole(SysRole sysRole) {
        sysRoleMapper.insertSelective(sysRole);
    }

    public List<MenuVO> menu() {
        List<MenuVO> menuList = new ArrayList<MenuVO>();
        MenuVO menuVO;
        List<SysModuledef> moduledefList = CachedVOUtil.getModuledefList();
        for (SysModuledef moduledef : moduledefList) {
            if (moduledef.getModuleid().equalsIgnoreCase(moduledef.getParentmoduleid())) {
                menuVO = new MenuVO();
                menuVO.setText(moduledef.getName());
                menuVO.setIconCls(moduledef.getIcon());
                menuVO.setModuleid(moduledef.getModuleid());
                menuVO.setUrl(moduledef.getUrl());
                
                menuVO.setChildren(selectChildren(menuVO, moduledefList));
                menuList.add(menuVO);
            }
        }
        return menuList;
    }

    public List<MenuVO> selectChildren(MenuVO menu, List<SysModuledef> moduleDefList) {
        MenuVO menuVO;
        boolean leaf = true;
        List<MenuVO> menuList = new ArrayList<MenuVO>(0);
        for (SysModuledef moduleDef : moduleDefList) {
            if (!(moduleDef.getModuleid().equalsIgnoreCase(moduleDef.getParentmoduleid()))) {
                if (moduleDef.getParentmoduleid().equalsIgnoreCase(menu.getModuleid())) {
                    leaf = false;
                    menuVO = new MenuVO();
                    menuVO.setText(moduleDef.getName());
                    menuVO.setIconCls(moduleDef.getIcon());
                    menuVO.setModuleid(moduleDef.getModuleid());
                    menuVO.setUrl(moduleDef.getUrl());
                    menuVO.setChildren(selectChildren(menuVO, moduleDefList));
                    menuList.add(menuVO);
                }
            }
        }
        menu.setLeaf(leaf);
        return menuList;
    }

    public void setSysRoleMapper(SysRoleMapper sysRoleMapper) {
        this.sysRoleMapper = sysRoleMapper;
    }

}
