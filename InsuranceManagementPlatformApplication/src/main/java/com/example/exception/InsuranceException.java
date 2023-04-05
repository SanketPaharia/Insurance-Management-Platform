package com.example.exception;

public class InsuranceException extends RuntimeException{
    public InsuranceException() {
    }

    public InsuranceException(String message) {
        super(message);
    }
}
