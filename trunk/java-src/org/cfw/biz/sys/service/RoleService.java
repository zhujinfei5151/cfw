package org.cfw.biz.sys.service;

import java.util.List;

import org.cfw.biz.sys.model.SysRole;
import org.cfw.biz.sys.model.SysRoleModule;
import org.cfw.common.vo.MenuVO;

public interface RoleService {

    List<SysRole> queryByCreateAccount(String createAccount);

    List<MenuVO> menu(Short roleid) throws Exception;

    List<SysRole> query();

    void insertRole(SysRole sysRole);

    void updateRole(SysRole sysRole);

    void deleteRoleByRoleID(short roleid);

    void insertRoleModuleList(List<SysRoleModule> sysRoleModuleList);

    void updateRoleModuleList(short roleid, List<SysRoleModule> sysRoleModuleList);

    void deleteRoleModuleByRoleID(short roleid);

    short selectSeqSysRoleID();

    List<SysRoleModule> selectSysRoleModuleList(short roleid);
}
