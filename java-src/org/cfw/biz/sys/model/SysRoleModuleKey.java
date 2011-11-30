package org.cfw.biz.sys.model;

public class SysRoleModuleKey {
    private String moduleid;

    private Short roleid;

    public String getModuleid() {
        return moduleid;
    }

    public void setModuleid(String moduleid) {
        this.moduleid = moduleid == null ? null : moduleid.trim();
    }

    public Short getRoleid() {
        return roleid;
    }

    public void setRoleid(Short roleid) {
        this.roleid = roleid;
    }
}