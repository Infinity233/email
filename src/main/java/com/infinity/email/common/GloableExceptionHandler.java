package com.infinity.email.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GloableExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String defalutHandler() {

        return "error";
    }
}
