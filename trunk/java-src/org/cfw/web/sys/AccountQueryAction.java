package org.cfw.web.sys;

import java.util.List;

import org.cfw.biz.sys.model.SysAccountDTO;
import org.cfw.biz.sys.model.SysRole;
import org.cfw.biz.sys.service.AccountService;
import org.cfw.biz.sys.service.RoleService;
import org.cfw.common.vo.Page;
import org.cfw.web.common.BaseAction;

public class AccountQueryAction extends BaseAction {

    private AccountService accountService;
    private RoleService    roleService;
    private Page           accountpage;

    public String init() {
        return SUCCESS;
    }

    @SuppressWarnings("unchecked")
    public String query() throws Exception {
        String account = getRequestParam("account") == null ? "" : getRequestParam("account");
        String name = getRequestParam("name");
        name = unescape(name);
        int start = 0;
        int limit = Integer.MAX_VALUE;

        start = Integer.valueOf(getRequestParam("start"));
        limit = Integer.valueOf(getRequestParam("limit"));
        Page page = accountService.selectByPage(account, name, start, limit);
        List<SysAccountDTO> recordList = page.getRoot();
        for (SysAccountDTO record : recordList) {
            String roleid = record.getRoleid().toString();
            SysRole sysRole = roleService.selectSysRoleByPrimaryKey(Short.valueOf(roleid));
            if (sysRole != null) {
                record.setRoledesc(sysRole.getName());
            }
        }
        this.accountpage = page;
        return SUCCESS;
    }

    public Page getAccountpage() {
        return accountpage;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

}
