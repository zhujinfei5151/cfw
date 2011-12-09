package org.cfw.biz.sys.service;

import java.util.List;

import org.cfw.biz.sys.model.SysRole;
import org.cfw.common.vo.MenuVO;

public interface RoleService {

    List<SysRole> query();

    List<MenuVO> menu();

    void insertRole(SysRole sysRole);
}
