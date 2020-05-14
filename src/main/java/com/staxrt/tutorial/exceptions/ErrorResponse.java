package com.staxrt.tutorial.exceptions;

import java.time.LocalDate;

public class ErrorResponse {
    private LocalDate timestamp;
    private String status;
    private String message;
    private String details;

    public ErrorResponse(LocalDate timestamp, String status, String message, String details) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.details = details;
    }

}