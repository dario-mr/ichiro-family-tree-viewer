package com.dario.ift.api.v1.controller;

import com.dario.ift.api.v1.controller.dto.ErrorDto;
import com.dario.ift.core.exception.DownloadException;
import com.dario.ift.core.exception.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.Optional;

@ControllerAdvice
@ResponseBody
public class ErrorController extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ParseException.class, DownloadException.class})
    @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
    public ErrorDto genericException(RuntimeException ex) {
        String cause = Optional.ofNullable(ex.getCause()).map(Throwable::getMessage).orElse("");
        return new ErrorDto(ex.getMessage(), cause);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorDto validationException(ConstraintViolationException ex) {
        String cause = Optional.ofNullable(ex.getCause()).map(Throwable::getMessage).orElse("");
        return new ErrorDto(ex.getMessage(), cause);
    }

}
