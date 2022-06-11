package com.websecure.wsapi.Error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class UserExceptionHandlerAdvice {

    @ResponseBody
    @ExceptionHandler(UserExceptionHandler.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String exceptionHandlerAdvice(UserExceptionHandler exception) {
        return exception.getMessage();
    }
}
