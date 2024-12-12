package com.ratolla.PicPaySimplified.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class UnauthorizedTransferException extends PicPayException{
    @Override
    public ProblemDetail toProblemDetail() {
        var pd = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        pd.setTitle("Unauthorized Transfer");
        pd.setDetail("Authorization service did not authorized this transaction");
        return pd;
    }
}
