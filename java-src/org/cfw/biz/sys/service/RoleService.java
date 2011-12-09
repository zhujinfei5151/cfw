package org.cfw.biz.sys.service;

import java.util.List;

import org.cfw.biz.sys.model.SysRole;
import org.cfw.biz.sys.model.SysRoleModule;
import org.cfw.biz.sys.model.SysRoleModuleExample;
import org.cfw.common.vo.MenuVO;

public interface RoleService {

    List<SysRole> queryByCreateAccount(String createAccount);

    List<MenuVO> menu(short roleid);

    void insertRole(SysRole sysRole);

    void updateRole(SysRole sysRole);

    void deleteRoleByRoleID(short roleid);

    void insertRoleModuleList(List<SysRoleModule> sysRoleModuleList);

    void updateRoleModuleList(List<SysRoleModule> sysRoleModuleList);

    void deleteRoleModuleByExample(SysRoleModuleExample example);

    short selectSeqSysRoleID();

    List<SysRoleModule> selectSysRoleModuleList(short roleid);
}
