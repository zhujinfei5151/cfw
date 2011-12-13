package org.cfw.web.common;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.cfw.common.Constants;
import org.cfw.common.vo.WebUserVO;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {

    protected String errorMsg;

    public HttpServletRequest getRequest() {
        return ServletActionContext.getRequest();
    }

    public String getRequestParam(String key) {
        return getRequest().getParameter(key);
    }

    public void setRequestAttribute(String key, String value) {
        getRequest().setAttribute(key, value);
    }

    public HttpServletResponse getResponse() {
        return ServletActionContext.getResponse();
    }

    public ServletContext getServletContext() {
        return ServletActionContext.getServletContext();
    }

    public String getRealyPath(String path) {
        return getServletContext().getRealPath(path);
    }

    public HttpSession getSession() {
        return this.getRequest().getSession();
    }

    public void setSessionAttribute(String key, Object value) {
        synchronized (this) {
            getSession().setAttribute(key, value);
        }
    }

    public Object getSessionAttribute(String key) {
        return getSession().getAttribute(key);
    }

    public void removeSessionAttribute(String key) {
        getSession().removeAttribute(key);
    }

    public WebUserVO getCurrentUser() {
        return (WebUserVO) getSessionAttribute(Constants.CURRENTUSER);
    }

    public String getCurrentAccount() {
        WebUserVO user = getCurrentUser();
        if (user == null) return null;
        return user.getAccount();
    }

    public String getRemoteIP() {
        String ip = this.getRequest().getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = this.getRequest().getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = this.getRequest().getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = this.getRequest().getRemoteAddr();
        }
        return ip;
    }

    public boolean isAdmin() {
        String account = getCurrentAccount();
        return Constants.ADMIN.equals(account);
    }

}
