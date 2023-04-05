package com.example.exception;

public class ClaimException extends RuntimeException{

    public ClaimException() {
    }

    public ClaimException(String message) {
        super(message);
    }
}
