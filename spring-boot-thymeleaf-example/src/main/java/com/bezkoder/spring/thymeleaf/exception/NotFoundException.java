package com.bezkoder.spring.thymeleaf.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String m){
        super(m);
    }
}