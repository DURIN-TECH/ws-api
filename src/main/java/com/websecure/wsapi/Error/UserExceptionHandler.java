package com.websecure.wsapi.Error;

public class UserExceptionHandler extends Exception{
    public UserExceptionHandler() {
        super();
    }

    public UserExceptionHandler(String message) {
        super(message);
    }

    public UserExceptionHandler(String message, Throwable cause) {
        super(message, cause);
    }

    public UserExceptionHandler(Throwable cause) {
        super(cause);
    }

    protected UserExceptionHandler(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
