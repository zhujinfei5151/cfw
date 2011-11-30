package org.cfw.web.index;

import java.io.IOException;
import java.util.List;

import org.cfw.biz.service.LoginService;
import org.cfw.common.CachedVOUtil;
import org.cfw.common.Constants;
import org.cfw.common.vo.MenuVO;
import org.cfw.web.common.BaseAction;

@SuppressWarnings("serial")
public class LoginAction extends BaseAction {

    private List<MenuVO> menuList;
    private LoginService loginService;

    public String init() throws IOException {
        String loginMode = CachedVOUtil.getSysParam(Constants.LOGIN_MODE);
        if (loginMode.equals("1")) return "ext.index";
        else return "ext.login";
    }

    public String login() {
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

}
