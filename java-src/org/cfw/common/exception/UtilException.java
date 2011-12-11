package org.cfw.common.exception;

/**
 * The exception class of util operation.
 */
public class UtilException extends BaseException {

    private static final long serialVersionUID = 1L;

    public UtilException(String errorCode) {
        super(errorCode);
        this.errorCode = errorCode;
    }

    public UtilException(Exception e) {
        super(e);
    }

    public UtilException(String errorCode, Exception e) {
        super(errorCode, e);
    }
}
