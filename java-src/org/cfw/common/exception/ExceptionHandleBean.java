package org.cfw.common.exception;

/**
 * 错误属性bean
 * 
 * @author zhouli
 */
public class ExceptionHandleBean {

    private String needMail;
    private String needLog;
    private String needAlarm;

    public String getNeedMail() {
        return needMail;
    }

    public void setNeedMail(String needMail) {
        this.needMail = needMail;
    }

    public String getNeedLog() {
        return needLog;
    }

    public void setNeedLog(String needLog) {
        this.needLog = needLog;
    }

    public String getNeedAlarm() {
        return needAlarm;
    }

    public void setNeedAlarm(String needAlarm) {
        this.needAlarm = needAlarm;
    }

}
