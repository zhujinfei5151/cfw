package org.cfw.common.exception;

/**
 * The exception class of application.
 */
public class ApplicationException extends BaseException {

    private static final long serialVersionUID = 1L;

    public ApplicationException(String errorCode) {
        super(errorCode);
        this.errorCode = errorCode;
    }

    /**
     * Constructor
     * 
     * @param errorCode
     */
    public ApplicationException(Exception e) {
        super(e);
    }

    /**
     * Constructor
     * 
     * @param e
     * @param errorCode
     */
    public ApplicationException(String errorCode, Exception e) {
        super(errorCode, e);
    }

}
