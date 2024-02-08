package com.example.user_management.exceptions;

public class ExistingResourceException extends RuntimeException{
    public ExistingResourceException() {
    }

    public ExistingResourceException(String message) {
        super(message);
    }

    public ExistingResourceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExistingResourceException(Throwable cause) {
        super(cause);
    }

    public ExistingResourceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
