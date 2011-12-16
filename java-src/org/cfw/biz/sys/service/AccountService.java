package org.cfw.biz.sys.service;

import java.util.List;

import org.cfw.biz.sys.model.SysAccount;

public interface AccountService {

    List<SysAccount> query(String loginAccount);

    int insert(SysAccount sysAccount);

    SysAccount selectSysAccountByAccount(String account);

    int updateSysAccountByPrimaryKeySelective(SysAccount sysAccount);

    int deleteSysAccountByAccount(String account);
}
