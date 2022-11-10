package com.andreyan.task.config;


import com.andreyan.task.exception.MessageException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ErrorHandlerConfig extends ResponseEntityExceptionHandler {


    @ExceptionHandler(value = {MessageException.class})
    protected ResponseEntity<Object> handlePSQLException(MessageException ex, WebRequest request) {
        return handleExceptionInternal(ex, null, new HttpHeaders(), HttpStatus.PRECONDITION_FAILED, request);
    }
}

