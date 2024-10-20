package com.example.crm.error.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private String message;
    private long id;

    public ErrorResponse(String message) {
        this.message = message;
    }
}
