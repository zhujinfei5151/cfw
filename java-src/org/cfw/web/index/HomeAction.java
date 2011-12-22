package org.cfw.web.index;

import java.util.List;

import org.cfw.biz.service.HomeService;
import org.cfw.common.Constants;
import org.cfw.common.vo.MenuVO;
import org.cfw.common.vo.ModulePermitVO;
import org.cfw.common.vo.WebUserVO;
import org.cfw.web.common.BaseAction;

@SuppressWarnings("serial")
public class HomeAction extends BaseAction {

    private List<MenuVO> tabList;
    private HomeService  homeService;
    private List<MenuVO> menuList;
    private String       moduleid;

    public String menu() throws Exception {
        WebUserVO user = getCurrentUser();
        menuList = homeService.constructMenu(user.getPermission().getModuleList());
        return SUCCESS;
    }

    public String tab() {
        return SUCCESS;
    }

    public String menutree() {
        setSessionAttribute(Constants.CURRENTMENUID, moduleid);
        return SUCCESS;
    }

    public String submenu() {
        WebUserVO user = getCurrentUser();
        moduleid = (String) getSessionAttribute(Constants.CURRENTMENUID);
        menuList = homeService.constructSubMenu(moduleid, user.getPermission().getModuleList());
        return SUCCESS;
    }

    public String objtree() {
        return SUCCESS;
    }

    public String tabstore() {
        String moduleid = getRequest().getParameter("moduleid");
        List<ModulePermitVO> moduleList = getCurrentUser().getPermission().getModuleList();
        tabList = homeService.constructTabs(moduleid, moduleList);
        return SUCCESS;
    }

    public List<MenuVO> getTabList() {
        return tabList;
    }

    public void setHomeService(HomeService homeService) {
        this.homeService = homeService;
    }

    public List<MenuVO> getMenuList() {
        return menuList;
    }

    public void setModuleid(String moduleid) {
        this.moduleid = moduleid;
    }

}
