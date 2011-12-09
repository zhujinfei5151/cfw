package org.cfw.biz.sys.model;

import java.util.Date;

public class SysRole {
    private Short roleid;

    private String name;

    private Short parentroleid;

    private Date createtime;

    private String createaccount;

    private String comment;

    public Short getRoleid() {
        return roleid;
    }

    public void setRoleid(Short roleid) {
        this.roleid = roleid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Short getParentroleid() {
        return parentroleid;
    }

    public void setParentroleid(Short parentroleid) {
        this.parentroleid = parentroleid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getCreateaccount() {
        return createaccount;
    }

    public void setCreateaccount(String createaccount) {
        this.createaccount = createaccount == null ? null : createaccount.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

}