package com.example.exception;


public class ClientException extends RuntimeException {
    public ClientException(String message) {
        super(message);
    }

    public ClientException() {
        super();
    }
}
