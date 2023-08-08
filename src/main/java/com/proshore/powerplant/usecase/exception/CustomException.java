package com.proshore.powerplant.usecase.exception;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException{

    private String message;
    private HttpStatus status = HttpStatus.BAD_REQUEST;

    public CustomException() {
    }

    public CustomException(String msg) {
        super(msg);
        this.message = msg;
    }

    public CustomException(String msg, HttpStatus status) {
        super(msg);
        this.message = msg;
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
