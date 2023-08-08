package com.proshore.powerplant.usecase.exception;

public class BadRequestException extends CustomException {

    private String message;

    public BadRequestException() {
    }

    public BadRequestException(String msg) {
        super(msg);
        this.message = msg;
    }
}
