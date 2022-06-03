package com.api.products.advisers;

import com.api.products.Models.ExceptionAuth;
import com.api.products.Models.ExceptionBadReq;
import com.api.products.Models.ExceptionDuplicate;
import com.api.products.Models.ExceptionResponse;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdviser {

    @ExceptionHandler(ExceptionAuth.class)
    public ResponseEntity<ExceptionResponse> handleExceptionsUnothorized( Exception e) {
        HttpStatus status =  HttpStatus.UNAUTHORIZED;
        return new ResponseEntity<>(
            new ExceptionResponse(
              status, 
              e.getMessage()
            ),
            status
        );
    }
    @ExceptionHandler(ExceptionBadReq.class)
    public ResponseEntity<ExceptionResponse> handleExceptionsBadRequest(Exception e) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(
                new ExceptionResponse(
                        status,
                        e.getMessage()),
                status);
    }

    @ExceptionHandler(ExceptionDuplicate.class)
    public ResponseEntity<ExceptionResponse> handleExceptionsConflict( Exception e) {
        HttpStatus status =  HttpStatus.CONFLICT;
        return new ResponseEntity<>(
            new ExceptionResponse(
              status, 
              e.getMessage()
            ),
            status
        );
    }
}
