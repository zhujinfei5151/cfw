package org.cfw.web.index;

import java.util.List;

import org.cfw.biz.service.HomeService;
import org.cfw.common.vo.MenuVO;
import org.cfw.web.common.BaseAction;

@SuppressWarnings("serial")
public class HomeAction extends BaseAction {

    private List<MenuVO> tabList;
    private HomeService  homeService;

    public String tab() {
        return SUCCESS;
    }

    public String tabstore() {
        String moduleid = getRequest().getParameter("moduleid");
        tabList = homeService.constructTabs(moduleid);
        return SUCCESS;
    }

    public List<MenuVO> getTabList() {
        return tabList;
    }

    public void setHomeService(HomeService homeService) {
        this.homeService = homeService;
    }

}
