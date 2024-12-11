package com.ratolla.PicPaySimplified.controllers;

import com.ratolla.PicPaySimplified.exceptions.PicPayException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(PicPayException.class)
    public ProblemDetail handlePicPayExpection(PicPayException exception){
        return exception.toProblemDetail();
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){

        var invalidFields = ex.getFieldErrors()
                .stream()
                .map(fieldError -> new fieldError(fieldError.getField(), fieldError.getDefaultMessage()))
                .toList();
        var pd = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        pd.setTitle("Your Request Params didn’t validade");
        pd.setProperty("invalid-params", invalidFields);


        return pd;
    }
    public record fieldError(String name, String reason){}
}
