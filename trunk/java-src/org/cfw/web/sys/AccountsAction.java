package org.cfw.web.sys;

import java.util.List;

import org.cfw.biz.sys.model.SysRole;
import org.cfw.biz.sys.service.RoleService;
import org.cfw.web.common.BaseAction;

@SuppressWarnings("serial")
public class AccountsAction extends BaseAction {

    private RoleService   roleService;
    private List<SysRole> roleList;

    public String init() {
        return SUCCESS;
    }

    public String query() {
        return SUCCESS;
    }

    public String add() {
        return SUCCESS;
    }

    public String modify() {
        return SUCCESS;
    }

    public String delete() {
        return SUCCESS;
    }

    public List<SysRole> getRoleList() {
        return roleList;
    }

    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

}
