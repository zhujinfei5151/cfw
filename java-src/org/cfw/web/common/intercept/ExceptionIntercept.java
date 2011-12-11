package org.cfw.web.common.intercept;

import java.io.IOException;

import org.cfw.common.exception.BaseException;
import org.cfw.common.exception.ExceptionHandle;
import org.springframework.dao.DataAccessException;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 异常拦截器<br>
 * 在action执行后拦截错误。可以对错误进行包装，配置资源文件的id<br>
 * 暂时不包装exception,捕获runtimeException抛出还是runtimeException<br>
 */
public class ExceptionIntercept extends AbstractInterceptor {

    private static final long serialVersionUID = 8957854501326993536L;

    /**
     * 拦截异常
     */
    public String intercept(ActionInvocation invocation) throws Exception {

        String result = "";
        try {
            result = invocation.invoke();
        } catch (BaseException ex) {
            // 捕捉我们自定义的异常，处理后再抛出
            ExceptionHandle.handleCheckedException(ex);
            throw ex;
        } catch (DataAccessException ex) {
            ExceptionHandle.handleUnCheckedException(ex);
            throw new RuntimeException("error.dataAccess", ex);
        } catch (NullPointerException ex) {
            ExceptionHandle.handleUnCheckedException(ex);
            throw new RuntimeException("error.null", ex);
        } catch (IOException ex) {
            ExceptionHandle.handleUnCheckedException(ex);
            throw new RuntimeException("error.io", ex);
        } catch (ClassNotFoundException ex) {
            ExceptionHandle.handleUnCheckedException(ex);
            throw new RuntimeException("error.classNotFind", ex);
        } catch (ClassCastException ex) {
            ExceptionHandle.handleUnCheckedException(ex);
            throw new RuntimeException("error.classCast", ex);
        } catch (SecurityException ex) {
            ExceptionHandle.handleUnCheckedException(ex);
            throw new RuntimeException("error.security", ex);
        } catch (Exception ex) {
            ExceptionHandle.handleUnCheckedException(ex);
            throw new RuntimeException(ex);
        }

        return result;
    }
}
