package org.cfw.biz.sys.service.impl;

import java.util.List;

import org.cfw.biz.sys.dao.SysAccountMapper;
import org.cfw.biz.sys.model.SysAccount;
import org.cfw.biz.sys.model.SysAccountExample;
import org.cfw.biz.sys.service.AccountService;

public class AccountServiceImpl implements AccountService {

    private SysAccountMapper sysAccountMapper;

    public List<SysAccount> query(String loginAccount) {
        SysAccountExample example = new SysAccountExample();
        example.createCriteria().andCreateaccountEqualTo(loginAccount);
        return sysAccountMapper.selectByExample(example);
    }

    public int insert(SysAccount sysAccount) {
        return sysAccountMapper.insertSelective(sysAccount);
    }

    public SysAccount selectSysAccountByAccount(String account) {
        return sysAccountMapper.selectByPrimaryKey(account);
    }

    public void setSysAccountMapper(SysAccountMapper sysAccountMapper) {
        this.sysAccountMapper = sysAccountMapper;
    }

}
