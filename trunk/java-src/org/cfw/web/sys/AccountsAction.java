package org.cfw.web.sys;

import java.util.Date;
import java.util.List;

import org.cfw.biz.sys.model.SysAccount;
import org.cfw.biz.sys.service.AccountService;
import org.cfw.web.common.BaseAction;

@SuppressWarnings("serial")
public class AccountsAction extends BaseAction {

    private AccountService   accountService;
    private List<SysAccount> accountList;
    private boolean          success = true;

    public String init() {
        return SUCCESS;
    }

    public String query() {
        String loginAccount = "admin";
        accountList = accountService.query(loginAccount);
        return SUCCESS;
    }

    public String add() {
        String loginAccount = "admin";
        String account = this.getRequest().getParameter("account");
        String name = this.getRequest().getParameter("name");
        String sex = this.getRequest().getParameter("sex");
        String roleid = this.getRequest().getParameter("roleid");
        String position = this.getRequest().getParameter("position");
        String note = this.getRequest().getParameter("note");

        SysAccount sysAccount = new SysAccount();
        sysAccount.setAccount(account);
        sysAccount.setName(name);
        sysAccount.setPassword((short) Integer.parseInt("1234"));
        sysAccount.setRoleid((short) Integer.parseInt(roleid));
        sysAccount.setSex((short) Integer.parseInt(sex));
        sysAccount.setPosition(position);
        sysAccount.setCreateaccount(loginAccount);
        sysAccount.setCreatetime(new Date());
        sysAccount.setNote(note);

        if (accountService.insert(sysAccount) >= 0) {
            this.success = true;
        } else {
            this.success = false;
        }
        return SUCCESS;
    }

    public String modify() {
        String account = this.getRequest().getParameter("account");
        String name = this.getRequest().getParameter("name");
        String roleid = this.getRequest().getParameter("roleid");
        String position = this.getRequest().getParameter("position");
        String note = this.getRequest().getParameter("note");

        SysAccount sysAccount = accountService.selectSysAccountByAccount(account);
        if (sysAccount == null) {
            this.success = false;
            return SUCCESS;
        }
        sysAccount.setName(name);
        sysAccount.setRoleid((short) Integer.parseInt(roleid));
        sysAccount.setPosition(position);
        sysAccount.setNote(note);

        return SUCCESS;
    }

    public String delete() {
        return SUCCESS;
    }

    public List<SysAccount> getAccountList() {
        return accountList;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

}
