package org.cfw.biz.sys.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.cfw.biz.sys.dao.SysRoleMapper;
import org.cfw.biz.sys.dao.SysRoleModuleMapper;
import org.cfw.biz.sys.model.SysModuledef;
import org.cfw.biz.sys.model.SysRole;
import org.cfw.biz.sys.model.SysRoleExample;
import org.cfw.biz.sys.model.SysRoleModule;
import org.cfw.biz.sys.model.SysRoleModuleExample;
import org.cfw.biz.sys.service.RoleService;
import org.cfw.common.CachedVOUtil;
import org.cfw.common.enums.ModuleMaskEnum;
import org.cfw.common.vo.MenuVO;

public class RoleServiceImpl implements RoleService {

    private SysRoleMapper       sysRoleMapper;
    private SysRoleModuleMapper sysRoleModuleMapper;

    public List<SysRole> queryByCreateAccount(String createAccount) {
        SysRoleExample example = new SysRoleExample();
        SysRoleExample.Criteria cr = example.createCriteria();
        cr.andCreateaccountEqualTo(createAccount);
        return sysRoleMapper.selectByExample(example);
    }

    public void insertRole(SysRole sysRole) {
        sysRoleMapper.insertSelective(sysRole);
    }

    public void updateRole(SysRole sysRole) {
        sysRoleMapper.updateByPrimaryKeySelective(sysRole);
    }

    public void deleteRoleByRoleID(short roleid) {
        sysRoleMapper.deleteByPrimaryKey(roleid);
    }

    public void insertRoleModuleList(List<SysRoleModule> sysRoleModuleList) {
        for (SysRoleModule sysRoleModule : sysRoleModuleList) {
            sysRoleModuleMapper.insert(sysRoleModule);
        }
    }

    public void updateRoleModuleList(short roleid, List<SysRoleModule> sysRoleModuleList) {
        deleteRoleModuleByRoleID(roleid);
        for (SysRoleModule sysRoleModule : sysRoleModuleList) {
            sysRoleModuleMapper.insert(sysRoleModule);
        }
    }

    public void deleteRoleModuleByRoleID(short roleid) {
        SysRoleModuleExample example = new SysRoleModuleExample();
        SysRoleModuleExample.Criteria cr = example.createCriteria();
        cr.andRoleidEqualTo(roleid);
        sysRoleModuleMapper.deleteByExample(example);
    }

    public List<SysRoleModule> selectSysRoleModuleList(short roleid) {
        SysRoleModuleExample example = new SysRoleModuleExample();
        SysRoleModuleExample.Criteria cr = example.createCriteria();
        cr.andRoleidEqualTo(roleid);
        return sysRoleModuleMapper.selectByExample(example);
    }

    public List<MenuVO> menu(Short roleid) throws Exception {
        List<MenuVO> menuList = new ArrayList<MenuVO>();
        MenuVO menuVO;
        List<SysModuledef> moduledefList = null;
        if (roleid == null) {
            moduledefList = CachedVOUtil.getModuledefList();
        } else {
            moduledefList = sysRoleModuleMapper.selectModuledefByRoleID(roleid);
        }
        for (SysModuledef moduledef : moduledefList) {
            if (moduledef.getModuleid().equalsIgnoreCase(moduledef.getParentmoduleid())) {
                menuVO = new MenuVO();
                menuVO.setText(moduledef.getName());
                menuVO.setIconCls(moduledef.getIcon());
                menuVO.setModuleid(moduledef.getModuleid());
                menuVO.setUrl(moduledef.getUrl());
                if (roleid == null) {// 超级管理员
                    menuVO.setMask(ModuleMaskEnum.CONTROL.getShortValue());// 赋控制权限
                } else {
                    menuVO.setMask(moduledef.getMask());
                }
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
                    menuVO.setMask(moduleDef.getMask());
                    menuVO.setChildren(selectChildren(menuVO, moduleDefList));
                    menuList.add(menuVO);
                }
            }
        }
        menu.setLeaf(leaf);
        return menuList;
    }

    public short selectSeqSysRoleID() {
        return (short) sysRoleMapper.selectSeqSysRoleID();
    }

    public List<SysRole> query() {
        return sysRoleMapper.selectByExample(null);
    }

    public void setSysRoleMapper(SysRoleMapper sysRoleMapper) {
        this.sysRoleMapper = sysRoleMapper;
    }

    public void setSysRoleModuleMapper(SysRoleModuleMapper sysRoleModuleMapper) {
        this.sysRoleModuleMapper = sysRoleModuleMapper;
    }

}
