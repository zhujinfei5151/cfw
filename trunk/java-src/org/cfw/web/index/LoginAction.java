package org.cfw.web.index;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.cfw.biz.service.LoginService;
import org.cfw.biz.sys.model.SysAccount;
import org.cfw.common.CachedVOUtil;
import org.cfw.common.Constants;
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
        // System.out.println("用户输入：" + checkcode);
        // System.out.println("session中的：" + scode);
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
                    if (password.equals(sysAccount.getPassword().toString())) {
                        this.success = true;
                        this.msg = "登录成功!";
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
