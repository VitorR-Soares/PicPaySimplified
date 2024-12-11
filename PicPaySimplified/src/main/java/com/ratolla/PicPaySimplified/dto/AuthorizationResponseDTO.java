package com.ratolla.PicPaySimplified.dto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public record AuthorizationResponseDTO(boolean authorized) {
}
