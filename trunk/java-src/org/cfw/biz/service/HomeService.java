package org.cfw.biz.service;

import java.util.List;

import org.cfw.common.vo.MenuVO;
import org.cfw.common.vo.ModulePermitVO;

public interface HomeService {

    List<MenuVO> constructMenu(List<ModulePermitVO> moduleList);

    List<MenuVO> constructTabs(String moduleid, List<ModulePermitVO> moduleList);
}
