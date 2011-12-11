package org.cfw.common.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 异常处理
 */
public class ExceptionHandle {

    private static Log         log                    = LogFactory.getLog(BaseException.class);

    private static String      TRUE                   = "true";
    public static final String LOGTYPE_ERROR          = "error";

    /**
     * logging type for warning messages.
     */
    public static final String LOGTYPE_WARN           = "warning";

    /**
     * logging type for info messages.
     */
    public static final String LOGTYPE_INFO           = "info";

    /**
     * logging type for no logging.
     */
    public static final String LOGTYPE_NOLOG          = "nologging";

    /**
     * The length of exception trace beyond which it will be truncated
     */
    public static final int    EXCEPTION_TRACE_LENGTH = 4000;

    static final String        DOT                    = ".";

    private static final int   INIT_BUFFER_SIZE       = 1024;

    public static String getDetailedMessage(BaseException exception) {
        StringBuffer msg = new StringBuffer(INIT_BUFFER_SIZE);

        if (exception.getMessage() != null) {
            msg.append("Message : ");
            msg.append(exception.getMessage());
            msg.append("\n");
        }

        msg.append("Exception Stack Trace\n");
        try {
            StringWriter sw = new StringWriter(INIT_BUFFER_SIZE);
            PrintWriter pw = new PrintWriter(sw);
            exception.printStackTrace(pw);
            msg.append(sw.toString());
            sw.close();
        } catch (Exception e) {
            msg.append(exception.toString());
        }
        Throwable rootCause = exception.getCause();
        if (rootCause != null) {
            msg.append("\n Root Exception Stack Trace : ");
            msg.append(rootCause.toString());
            msg.append("\n");
            try {
                StringWriter sw = new StringWriter(INIT_BUFFER_SIZE);
                PrintWriter pw = new PrintWriter(sw);
                rootCause.printStackTrace(pw);
                msg.append(sw.toString());
                sw.close();
            } catch (Exception e) {
                msg.append(rootCause.toString());
            }
        }
        return msg.toString();
    }

    /**
     * Gets the stack trace of a <code>Throwable</code> in String form.
     * 
     * @param a Throwable object.
     * @return <code>String</code> Returns the message as String.
     */
    public static String getDetailedMessage(Throwable a) {
        StringBuffer msg = new StringBuffer();

        msg.append("Message : ");
        msg.append(a.getMessage());
        msg.append("\n");
        msg.append("Exception Stack Trace\n");
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            a.printStackTrace(pw);
            msg.append(sw.toString());
            sw.close();
        } catch (Exception e) {
            msg.append(a.toString());
        }
        String ret = msg.toString();
        msg = null;
        return ret;
    }

    public static String getClassName(Throwable e) {
        String className = e.getClass().getName();
        String errId = className;

        if (e instanceof BaseException) {
            int i = className.lastIndexOf('.');
            errId = className.substring(i + 1);
        }
        return errId;
    }

    /**
     * Gets the detailed message of a <code>BaseAppException</code> including stack trace, userId and errorId
     * information in String form. This detailed message is used as a stack trace for log file as well as database.
     * 
     * @param exp BaseAppException object
     * @param userId the user for which exception occured.
     * @return the detailed message.
     */
    public static String getExceptionLog(Throwable exp) {
        String errorId = getClassName(exp);
        String detailedMessage = null;
        if (exp instanceof BaseException) {
            BaseException ie = (BaseException) exp;
            detailedMessage = getDetailedMessage(ie);
        } else {
            detailedMessage = getDetailedMessage(exp);
        }

        StringBuffer lBuffer = new StringBuffer(INIT_BUFFER_SIZE);
        String msg = null;
        lBuffer.append("ERRORID :");
        lBuffer.append(errorId);
        lBuffer.append("\n");

        lBuffer.append("EXCEPTION MESSAGE :");
        lBuffer.append(detailedMessage);
        lBuffer.append("\n");
        lBuffer.append("--------------------------------------------------------------------------------------\n");

        msg = lBuffer.toString();
        return msg;
    }

    /**
     * 对配置的异常进行处理:发邮件，记log，发警报
     * 
     * @param exception
     */
    @SuppressWarnings("unused")
    public static void handleCheckedException(BaseException exception) {

        String exceptionClassName = exception.getClass().getName();
        ExceptionHandleBean bean = new ExceptionHandleBean();
        if (bean == null) {
            return;
        }
        String needLog = bean.getNeedLog();
        String needMail = bean.getNeedMail();
        String needAlerm = bean.getNeedAlarm();
        // String needStackTrace = ExceptionHelper.getExceptionParameterValue(exceptionClass, "needStackTrace");

        // 记录log
        if (TRUE.equals(needLog)) {
            log.error(exceptionClassName + " : " + exception.getMessage());
        }

        // 发送email
        if (TRUE.equals(needMail)) {
            sendMail();
        }
        // 发送警报
        if (TRUE.equals(needAlerm)) {
            sendAlerm();
        }
    }

    /**
     * 发送email
     */
    private static boolean sendMail() {
        return true;
    }

    /**
     * 发送警报
     */
    private static boolean sendAlerm() {
        return true;
    }

    /**
     * 处理unchecked异常
     * 
     * @param exp
     * @return
     */
    public static String handleUnCheckedException(Exception exp) {
        String exceptionTrace = getExceptionLog(exp);
        log.error(exceptionTrace);
        return null;
    }

}
