package com.ratolla.PicPaySimplified.controllers;

import com.ratolla.PicPaySimplified.exceptions.PicPayException;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(PicPayException.class)
    public ProblemDetail handlePicPayExpection(PicPayException exception){
        return exception.toProblemDetail();
    }

}
