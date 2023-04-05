package com.example.exception;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MyError {
    private LocalDateTime timeStamp;
    private String message;
    private String details;
    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }
    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getDetails() {
        return details;
    }
    public void setDetails(String details) {
        this.details = details;
    }
}
