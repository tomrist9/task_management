package com.example.user_management.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {
    private HttpStatus status;
    private Integer error;
    private List<String> messages;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date timestamp;

    public ErrorResponse() {

        this.messages = new ArrayList<>();
        this.timestamp = new Date();
    }

    public ErrorResponse(HttpStatus status, String message) {
        this();
        this.status=status;
        this.messages.add(message);
        this.error=status.value();
    }

    public ErrorResponse(HttpStatus status, List<String> messages) {
        this();
        this.status = status;
        this.messages.addAll(messages);
        this.error=status.value();
    }
}
