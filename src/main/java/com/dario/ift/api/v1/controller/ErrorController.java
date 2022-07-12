package com.dario.ift.api.v1.controller;

import com.dario.ift.core.exception.DownloadException;
import com.dario.ift.core.exception.ParseException;
import org.springdoc.api.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseBody
public class ErrorController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DownloadException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage downloadException(DownloadException ex) {
        return new ErrorMessage(ex.getMessage());
    }

    @ExceptionHandler(ParseException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage parseException(ParseException ex) {
        return new ErrorMessage(ex.getMessage());
    }

}
