package org.cfw.web.index;

import java.util.Map;

import org.cfw.biz.service.LoginService;
import org.cfw.biz.sys.model.SysAccount;
import org.cfw.web.common.BaseAction;

import com.opensymphony.xwork2.ActionContext;

@SuppressWarnings("serial")
public class AccountLoginAction extends BaseAction {

    private String       username;
    private String       password;
    private String       checkcode;
    private boolean      success = false;
    private String       msg;
    private LoginService loginService;
    private SysAccount   sysAccount;

    public String login() {
        Map<String, Object> session = ActionContext.getContext().getSession();
        String scode = (String) session.get("code");
        // System.out.println("用户输入：" + checkcode);
        // System.out.println("session中的：" + scode);
        sysAccount = loginService.selectByAccount(username);
        if (sysAccount == null) {
            this.success = false;
            this.msg = "用户名不存在";
        } else {
            if (username.equals(sysAccount.getAccount()) && password.equals(sysAccount.getPassword().toString())) {
                if (checkcode.toLowerCase().equals(scode.toLowerCase())) {
                    this.success = true;
                    this.msg = "登录成功";
                } else {
                    this.success = false;
                    this.msg = "验证码错误";
                }
            } else {
                this.success = false;
                this.msg = "用户名或密码错误";
            }
        }
        return SUCCESS;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCheckcode() {
        return checkcode;
    }

    public void setCheckcode(String checkcode) {
        this.checkcode = checkcode;
    }

    public SysAccount getSysAccount() {
        return sysAccount;
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

}
