package org.cfw.biz.sys.service;

import java.util.List;

import org.cfw.biz.sys.model.SysAccount;
import org.cfw.common.vo.Page;

public interface AccountService {

    List<SysAccount> query(String loginAccount);

    int insert(SysAccount sysAccount);

    SysAccount selectSysAccountByAccount(String account);

    int updateSysAccountByPrimaryKeySelective(SysAccount sysAccount);

    int deleteSysAccountByAccount(String account);

    /**
     * 分页查询用户信息
     * 
     * @param account 帐号
     * @param name 名称
     * @param start 起始行
     * @param limit 截止行
     * @return
     */
    Page selectByPage(String account, String name, int start, int limit);
}
