package com.ratolla.PicPaySimplified.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class WalletNotFoundException extends PicPayException {

    private Long id;

    public WalletNotFoundException(Long id) {
        this.id = id;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        var pd = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        pd.setTitle("Wallet Not Found");
        pd.setDetail("Wallet Not Found by ID" + id);

        return pd;
    }
}
