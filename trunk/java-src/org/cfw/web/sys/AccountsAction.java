package org.cfw.web.sys;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.cfw.biz.service.LoginService;
import org.cfw.biz.sys.model.SysAccount;
import org.cfw.biz.sys.model.SysRole;
import org.cfw.biz.sys.service.AccountService;
import org.cfw.biz.sys.service.RoleService;
import org.cfw.common.util.StringUtil;
import org.cfw.web.common.BaseAction;

@SuppressWarnings("serial")
public class AccountsAction extends BaseAction {

    private RoleService      roleService;
    private List<SysRole>    roleList;
    private LoginService     loginService;
    private boolean          success = true; // 给jsp异步加载时传参用

    private AccountService   accountService;
    private List<SysAccount> accountList;

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

    public String modifyPassword() throws Exception {
        String account = this.getCurrentAccount();
        String oldPassword = this.getRequest().getParameter("oldpassword");
        String newPassword = this.getRequest().getParameter("newpassword");
        String newPassword2 = this.getRequest().getParameter("newpassword2");

        SysAccount sysAccount = loginService.selectByAccount(account);
        if (sysAccount == null) {
            this.success = false;
            this.errorMsg = "账号不正确";
            return SUCCESS;
        }
        if (StringUtil.isNotEmpty(oldPassword)) {
            // if (!RijndaelUtil.encodePassword(oldPassword).equals(sysAccount.getPassword())) {
            if (!StringUtil.toShort(oldPassword).equals(sysAccount.getPassword())) {
                this.success = false;
                this.errorMsg = "旧密码不正确";
                return SUCCESS;
            }
            if (StringUtils.equals(newPassword, newPassword2)) {
                // sysAccount.setPassword(RijndaelUtil.encodePassword(newPassword));
                sysAccount.setPassword(StringUtil.toShort(newPassword));
            } else {
                this.success = false;
                this.errorMsg = "两次密码不一致！";
                return SUCCESS;
            }
        }
        this.success = accountService.updateSysAccountByPrimaryKeySelective(sysAccount) == 1 ? true : false;
        return SUCCESS;
    }

    public List<SysRole> getRoleList() {
        return roleList;
    }

    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public List<SysAccount> getAccountList() {
        return accountList;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

}
