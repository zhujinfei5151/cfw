package org.cfw.biz.service;

import java.io.IOException;
import java.util.List;

import org.cfw.common.vo.MenuVO;
import org.cfw.common.vo.ModulePermitVO;

public interface HomeService {

    List<MenuVO> constructMenu(List<ModulePermitVO> moduleList) throws IOException;

    List<MenuVO> constructTabs(String moduleid, List<ModulePermitVO> moduleList);

    List<MenuVO> constructSubMenu(String moduleid, List<ModulePermitVO> moduleList);
}
