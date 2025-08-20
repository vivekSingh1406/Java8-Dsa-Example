package com.bezkoder.spring.thymeleaf.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Map<String,Object>> notFound(NotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", ex.getMessage()));
    }
    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<Map<String,Object>> conflict(ConflictException ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("error", ex.getMessage()));
    }
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Map<String,Object>> bad(BadRequestException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", ex.getMessage()));
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,Object>> bean(MethodArgumentNotValidException ex){
        var errors = new LinkedHashMap<String, String>();
        ex.getBindingResult().getFieldErrors().forEach(f -> errors.put(f.getField(), f.getDefaultMessage()));
        return ResponseEntity.badRequest().body(Map.of("validationErrors", errors));
    }
}