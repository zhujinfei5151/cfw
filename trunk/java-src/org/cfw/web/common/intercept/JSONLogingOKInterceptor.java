package org.cfw.web.common.intercept;

import java.util.Map;

import org.cfw.common.Constants;
import org.cfw.common.vo.WebUserVO;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 权限拦截器<br>
 * 1 判断是否已经登录 <br>
 */
public class JSONLogingOKInterceptor extends AbstractInterceptor {

    private static final long serialVersionUID = 263973631301649276L;

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        if (!checkIsLogin()) {
            return "logout";
        }
        return invocation.invoke();
    }

    /**
     * 检测是否登录
     * 
     * @return
     */
    private boolean checkIsLogin() {
        Map<String, Object> session = ActionContext.getContext().getSession();
        WebUserVO user = (WebUserVO) session.get(Constants.CURRENTUSER);
        if (user == null) {
            return false;
        }
        return true;
    }
}
