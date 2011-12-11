package org.cfw.common.exception;

/**
 * Super class of all system exception.
 */
public class BaseException extends Exception {

    private static final long serialVersionUID = 1L;

    // private static Log log = LogFactory.getLog(BaseException.class);

    protected String          errorCode;
    protected Exception       errorCause;

    public BaseException(String errorCode) {
        super(errorCode);
        this.errorCode = errorCode;
    }

    /**
     * Constructor
     * 
     * @param e
     */
    public BaseException(Exception e) {
        super(e);
        this.errorCause = e;
    }

    /**
     * Constructor
     * 
     * @param e
     */
    public BaseException(String errorCode, Exception e) {
        super(errorCode, e);
        this.errorCode = errorCode;
        this.errorCause = e;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public Exception getErrorCause() {
        return errorCause;
    }

    public void setErrorCause(Exception errorCause) {
        this.errorCause = errorCause;
    }
}
