package org.cfw.biz.service;

import java.util.List;

import org.cfw.biz.sys.model.SysAccount;
import org.cfw.common.vo.MenuVO;

public interface LoginService {

    List<MenuVO> constructMenu();

    SysAccount selectByAccount(String account);
}
