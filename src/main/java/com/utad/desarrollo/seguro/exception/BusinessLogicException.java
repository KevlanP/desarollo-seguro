package com.utad.desarrollo.seguro.exception;

public class BusinessLogicException
        extends RuntimeException {

    private static final long serialVersionUID = 5909765591371271734L;

    public BusinessLogicException(
            String message) {
        super(message);
    }

    public BusinessLogicException(
            String message,
            Throwable cause) {
        super(message, cause);
    }

}
