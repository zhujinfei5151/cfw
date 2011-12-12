package org.cfw.biz.sys.model;

import java.util.Date;

public class SysAccount {
    private String account;

    private String name;

    private Short  password;

    private Short  roleid;

    private Short  sex;

    private String telephone;

    private String position;

    private Date   createtime;

    private String createaccount;

    private String homepage;

    private String email;

    private String note;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Short getPassword() {
        return password;
    }

    public void setPassword(Short password) {
        this.password = password;
    }

    public Short getRoleid() {
        return roleid;
    }

    public void setRoleid(Short roleid) {
        this.roleid = roleid;
    }

    public Short getSex() {
        return sex;
    }

    public void setSex(Short sex) {
        this.sex = sex;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
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

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage == null ? null : homepage.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

}
