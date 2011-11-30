package org.cfw.biz.sys.model;

public class SysModuledef {
    private String moduleid;

    private Short systemid;

    private String name;

    private Short mask;

    private Short ipgroupid;

    private String url;

    private String parentmoduleid;

    private Short sortno;

    private String icon;

    private String note;

    public String getModuleid() {
        return moduleid;
    }

    public void setModuleid(String moduleid) {
        this.moduleid = moduleid == null ? null : moduleid.trim();
    }

    public Short getSystemid() {
        return systemid;
    }

    public void setSystemid(Short systemid) {
        this.systemid = systemid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Short getMask() {
        return mask;
    }

    public void setMask(Short mask) {
        this.mask = mask;
    }

    public Short getIpgroupid() {
        return ipgroupid;
    }

    public void setIpgroupid(Short ipgroupid) {
        this.ipgroupid = ipgroupid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getParentmoduleid() {
        return parentmoduleid;
    }

    public void setParentmoduleid(String parentmoduleid) {
        this.parentmoduleid = parentmoduleid == null ? null : parentmoduleid.trim();
    }

    public Short getSortno() {
        return sortno;
    }

    public void setSortno(Short sortno) {
        this.sortno = sortno;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}