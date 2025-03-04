package com.softworkshub.todolistapi.exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {

    private String message;
    private LocalDateTime timestamp;
    private String details;

    public ErrorResponse(String message, String details) {
        this.message = message;
        this.timestamp = LocalDateTime.now();
        this.details = details;
    }
}
