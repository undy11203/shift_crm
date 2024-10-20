package com.example.crm.error.handler;

import com.example.crm.error.exception.AlreadyExsistException;
import com.example.crm.error.exception.NotFoundException;
import com.example.crm.error.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralizedExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException ex) {
        return new ResponseEntity<>(new ErrorResponse(ex.getMessage(), ex.getId()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AlreadyExsistException.class)
    public ResponseEntity<ErrorResponse> handleAlreadyExsistException(AlreadyExsistException ex) {
        return new ResponseEntity<>(new ErrorResponse(ex.getMessage()), HttpStatus.CONFLICT);
    }
}
