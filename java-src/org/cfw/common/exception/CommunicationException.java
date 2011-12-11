package org.cfw.common.exception;

/**
 * The exception class of communication.
 */
public class CommunicationException extends BaseException {

    private static final long serialVersionUID = 1L;

    public CommunicationException(String errorCode) {
        super(errorCode);
        this.errorCode = errorCode;
    }

    public CommunicationException(Exception e) {
        super(e);
    }

    /**
     * Constructor
     * 
     * @param e
     * @param errorCode
     */
    public CommunicationException(String errorCode, Exception e) {
        super(errorCode, e);
    }

}
