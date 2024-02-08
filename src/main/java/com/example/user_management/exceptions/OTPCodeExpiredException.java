package com.example.user_management.exceptions;

public class OTPCodeExpiredException extends RuntimeException{
    public OTPCodeExpiredException(Throwable cause) {
        super(cause);
    }

    public OTPCodeExpiredException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }



    public OTPCodeExpiredException(String message) {
        super(message);
    }

    public OTPCodeExpiredException(String message, Throwable cause) {
        super(message, cause);
    }
}
