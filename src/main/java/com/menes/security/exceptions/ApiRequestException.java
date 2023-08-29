package com.menes.security.exceptions;

public class ApiRequestException extends RuntimeException{
    public ApiRequestException(String message) {
        super(message);
    }
}
