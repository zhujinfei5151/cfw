package org.cfw.web.sys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.cfw.biz.sys.model.SysRole;
import org.cfw.biz.sys.model.SysRoleModule;
import org.cfw.biz.sys.service.RoleService;
import org.cfw.common.util.StringUtil;
import org.cfw.common.vo.MenuVO;
import org.cfw.common.vo.WebUserVO;
import org.cfw.web.common.BaseAction;

@SuppressWarnings("serial")
public class RolesAction extends BaseAction {

    private RoleService   roleService;
    private List<SysRole> roleList;
    private List<MenuVO>  menuList;
    private short         roleid;

    public String init() {
        return SUCCESS;
    }

    public String query() {
        // account
        String account = getCurrentAccount();
        roleList = roleService.queryByCreateAccount(account);
        for (SysRole role : roleList) {
            role.setRoleModuleList(roleService.selectSysRoleModuleList(role.getRoleid()));
        }
        return SUCCESS;
    }

    public String queryAllRole() {
        roleList = roleService.query();
        return SUCCESS;
    }

    public String menu() throws Exception {
        WebUserVO user = getCurrentUser();
        if (isAdmin()) {// 超级管理员不过滤功能模块
            menuList = roleService.menu(null);
        } else {
            menuList = roleService.menu(user.getRoleId());
        }
        return SUCCESS;
    }

    public List<SysRole> getRoleList() {
        return roleList;
    }

    public List<MenuVO> getMenuList() {
        return menuList;
    }

    public String addRole() {
        String data = getRequest().getParameter("data");
        String name = getRequest().getParameter("name");
        String comment = getRequest().getParameter("rolecomment");
        roleid = roleService.selectSeqSysRoleID();

        SysRole sysrole = new SysRole();
        sysrole.setRoleid(roleid);
        sysrole.setRolecomment(comment);
        // account
        sysrole.setCreateaccount(getCurrentAccount());
        sysrole.setCreatetime(new Date());
        sysrole.setName(name);
        roleService.insertRole(sysrole);

        List<SysRoleModule> sysRoleModuleList = new ArrayList<SysRoleModule>();
        SysRoleModule sysRoleModule;
        JSONObject jsonObject;

        JSONArray jsonArray = JSONArray.fromObject(data);
        int size = jsonArray.size();
        for (int i = 0; i < size; i++) {
            jsonObject = jsonArray.getJSONObject(i);
            sysRoleModule = new SysRoleModule();

            String mask = jsonObject.getString("mask");
            if (StringUtil.isEmpty(mask)) continue;
            sysRoleModule.setMask(Short.valueOf(mask));

            sysRoleModule.setModuleid(jsonObject.getString("moduleid"));
            sysRoleModule.setRoleid(roleid);
            sysRoleModuleList.add(sysRoleModule);
        }
        roleService.insertRoleModuleList(sysRoleModuleList);

        return SUCCESS;
    }

    public String modifyRole() {
        String data = getRequest().getParameter("data");
        String name = getRequest().getParameter("name");
        String comment = getRequest().getParameter("rolecomment");

        SysRole sysrole = new SysRole();
        sysrole.setRoleid(roleid);
        sysrole.setRolecomment(comment);
        sysrole.setName(name);
        roleService.updateRole(sysrole);

        List<SysRoleModule> sysRoleModuleList = new ArrayList<SysRoleModule>();
        SysRoleModule sysRoleModule;
        JSONObject jsonObject;

        JSONArray jsonArray = JSONArray.fromObject(data);
        int size = jsonArray.size();
        for (int i = 0; i < size; i++) {
            jsonObject = jsonArray.getJSONObject(i);
            sysRoleModule = new SysRoleModule();

            String mask = jsonObject.getString("mask");
            if (StringUtil.isEmpty(mask) || mask.equals("0")) continue;
            sysRoleModule.setMask(Short.valueOf(mask));

            sysRoleModule.setModuleid(jsonObject.getString("moduleid"));
            sysRoleModule.setRoleid(roleid);
            sysRoleModuleList.add(sysRoleModule);
        }
        roleService.updateRoleModuleList(roleid, sysRoleModuleList);

        return SUCCESS;
    }

    public String removeRole() {
        roleService.deleteRoleModuleByRoleID(roleid);

        roleService.deleteRoleByRoleID(roleid);

        return SUCCESS;
    }

    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    public short getRoleid() {
        return roleid;
    }

    public void setRoleid(short roleid) {
        this.roleid = roleid;
    }

}
