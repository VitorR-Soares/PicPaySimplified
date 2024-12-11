package com.ratolla.PicPaySimplified.services;

import com.ratolla.PicPaySimplified.clients.AuthorizationClient;
import com.ratolla.PicPaySimplified.entities.Transfer;
import com.ratolla.PicPaySimplified.exceptions.PicPayException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {

    private final AuthorizationClient authorizationClient;

    public AuthorizationService(AuthorizationClient authorizationClient) {
        this.authorizationClient = authorizationClient;
    }

    public boolean isAuthorized(Transfer transfer){
        var response = authorizationClient.isAuthorized();

        if(response.getStatusCode().isError()){
            throw new PicPayException();
        }

        return response.getBody().authorized();
    }
}
