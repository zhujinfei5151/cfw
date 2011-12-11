package org.cfw.common.exception;

/**
 * The exception class of database operation.
 */
public class DBException extends BaseException {

    private static final long serialVersionUID = 1L;

    public DBException(String errorCode) {
        super(errorCode);
        this.errorCode = errorCode;
    }

    public DBException(Exception e) {
        super(e);
    }

    /**
     * Constructor
     * 
     * @param e
     * @param errorCode
     */
    public DBException(Exception e, String errorCode) {
        super(errorCode, e);
    }

}
