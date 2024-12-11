package com.ratolla.PicPaySimplified.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class PicPayException extends RuntimeException {

    public ProblemDetail toProblemDetail(){
        var pd = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);

        pd.setTitle("Error at PicPay Simplified Application");

        return pd;
    }
}
