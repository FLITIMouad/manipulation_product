package com.api.products.Models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ExceptionResponse {
    @Autowired
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date timestamp;

    private int code;

    private String status;

    private String message;

    private String stackTrace;

    private Object data;

    public ExceptionResponse(
            HttpStatus httpStatus,
            String message) {
        this();

        this.code = httpStatus.value();
        this.status = httpStatus.name();
        this.message = message;
    }

    public ExceptionResponse(HttpStatus httpStatus, String message, String stackTrace) 
    {
         this(httpStatus,message);
        this.stackTrace = stackTrace;
    }

    public ExceptionResponse(HttpStatus httpStatus,String message,String stackTrace,Object data) {
        this(
                httpStatus,
                message,
                stackTrace);

        this.data = data;
    }
}
