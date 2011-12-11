package org.cfw.common.vo;

import java.util.Date;

/**
 * 登录人的信息<br>
 * 它也用来做登录验证<br>
 * loginout时候可以去掉此session<br>
 */
public class WebUserVO {

    private String       account;
    private String       name;
    private Date         loginDate; // 登录时间
    private Short        roleId;    // 岗位
    private String       ip;
    private PermissionVO permission; // 权限

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public Short getRoleId() {
        return roleId;
    }

    public void setRoleId(Short roleId) {
        this.roleId = roleId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public PermissionVO getPermission() {
        return permission;
    }

    public void setPermission(PermissionVO permission) {
        this.permission = permission;
    }

}
