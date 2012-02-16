package org.cfw.biz.sys.service.impl;

import java.util.List;

import org.cfw.biz.sys.dao.SysAccountMapper;
import org.cfw.biz.sys.model.SysAccount;
import org.cfw.biz.sys.model.SysAccountExample;
import org.cfw.biz.sys.service.AccountService;
import org.cfw.common.util.StringUtil;
import org.cfw.common.vo.Page;

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

    public int updateSysAccountByPrimaryKeySelective(SysAccount record) {
        return sysAccountMapper.updateByPrimaryKeySelective(record);
    }

    public int deleteSysAccountByAccount(String account) {
        return sysAccountMapper.deleteByPrimaryKey(account);
    }

    /**
     * 分页查询用户信息
     * 
     * @param account 帐号
     * @param desc 名称
     * @param start 起始行
     * @param limit 截止行
     * @return
     */
    public Page selectByPage(String account, String name, int start, int limit) {
        SysAccountExample example = new SysAccountExample();
        SysAccountExample.Criteria criteria = example.createCriteria();
        if (!StringUtil.isEmpty(account)) {
            criteria.andAccountLike("%" + account + "%");
        }
        if (!StringUtil.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        Page page = new Page(start, limit);
        example.setPage(page);

        page.setRoot(sysAccountMapper.selectByPage(example));
        page.setTotalProperty(example.getPage().getTotalProperty());
        return page;
    }

    public void setSysAccountMapper(SysAccountMapper sysAccountMapper) {
        this.sysAccountMapper = sysAccountMapper;
    }

}
