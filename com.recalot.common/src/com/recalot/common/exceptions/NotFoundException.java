package com.recalot.common.exceptions;

/**
 * @author Matthäus Schmedding (info@recalot.com)
 */
public class NotFoundException extends BaseException {

    public NotFoundException() {
        super();
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String format, String arg) {
        super(format, arg);
    }

    public NotFoundException(String format, String arg1, String arg2) {
        super(format, arg1, arg2);
    }

    public NotFoundException(String format, String arg1, String arg2, String arg3) {
        super(format, arg1, arg2);
    }

    public NotFoundException(String format, String arg1, String arg2, String arg3, String arg4) {
        super(format, arg1, arg2, arg3, arg4);
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }
}
