package com.bezkoder.spring.thymeleaf.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String m){
        super(m);
    }
}
