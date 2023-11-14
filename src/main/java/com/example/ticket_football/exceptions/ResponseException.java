package com.example.ticket_football.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ResponseException extends RuntimeException{
    private String message;
    private HttpStatus httpStatus;
    private Long code;
}
