package com.bezkoder.spring.thymeleaf.exception;

public class ConflictException extends RuntimeException {
    public ConflictException(String m){
        super(m);
    }
}