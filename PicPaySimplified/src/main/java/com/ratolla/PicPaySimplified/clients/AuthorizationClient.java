package com.ratolla.PicPaySimplified.clients;

import com.ratolla.PicPaySimplified.dto.AuthorizationResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        url = "${authorization.client.url}"
)
public interface AuthorizationClient {
    @GetMapping
    public ResponseEntity<AuthorizationResponseDTO> isAuthorized();
}
