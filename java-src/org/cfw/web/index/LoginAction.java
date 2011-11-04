package org.cfw.web.index;

import java.util.List;

import org.cfw.biz.service.LoginService;
import org.cfw.web.common.BaseAction;
import org.cfw.web.common.vo.MenuVO;


@SuppressWarnings("serial")
public class LoginAction extends BaseAction {

    private List<MenuVO> menuList;
    private LoginService loginService;

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
