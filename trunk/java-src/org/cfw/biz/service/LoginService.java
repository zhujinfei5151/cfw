package org.cfw.biz.service;

import java.util.List;

import org.cfw.biz.sys.model.SysAccount;
import org.cfw.common.vo.ModulePermitVO;

public interface LoginService {

    SysAccount selectByAccount(String account);

    List<ModulePermitVO> selectSysRoleModuleList(short roleid);

    List<ModulePermitVO> selectGuestModuleList();
}
