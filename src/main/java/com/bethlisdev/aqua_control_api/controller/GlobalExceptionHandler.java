package com.bethlisdev.aqua_control_api.controller;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.bethlisdev.aqua_control_api.Messages;
import com.bethlisdev.aqua_control_api.exception.GoogleAuthenticationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GoogleAuthenticationException.class)
    public ResponseEntity<Map<String, Object>> handleGoogleAuthenticationException(GoogleAuthenticationException ex) {
        Map<String, Object> errorBody = new LinkedHashMap<>();
        errorBody.put("timestamp", LocalDateTime.now());
        errorBody.put("status", HttpStatus.UNAUTHORIZED.value());
        errorBody.put("error", Messages.UNAUTHORIZED);
        errorBody.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorBody);
    }
}
