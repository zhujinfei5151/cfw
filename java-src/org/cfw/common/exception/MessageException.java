package org.cfw.common.exception;

/**
 * The exception class of transaction.
 */
public class MessageException extends BaseException {

    private static final long serialVersionUID = 1L;

    public MessageException(String errorCode) {
        super(errorCode);
        this.errorCode = errorCode;
    }

    public MessageException(Exception e) {
        super(e);
    }

    /**
     * Constructor
     * 
     * @param e
     * @param errorCode
     */
    public MessageException(String errorCode, Exception e) {
        super(errorCode, e);
    }

}
