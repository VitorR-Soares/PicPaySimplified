package com.ratolla.PicPaySimplified.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class UnauthorizedTransferForWallletTypeException extends PicPayException {
    @Override
    public ProblemDetail toProblemDetail() {
        var pd = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        pd.setTitle("Unauthorized Transfer");
        pd.setDetail("Your WalletType is not allowed to make Transactions");

        return pd;
    }
}
