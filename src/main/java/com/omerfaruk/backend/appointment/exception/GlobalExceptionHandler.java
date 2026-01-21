package com.omerfaruk.backend.appointment.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice

public class GlobalExceptionHandler {
    public ResponseEntity<String> handleBusinessException(BusinessException ex){
        return ResponseEntity
                .badRequest()
                .body(ex.getMessage());
    }
}
