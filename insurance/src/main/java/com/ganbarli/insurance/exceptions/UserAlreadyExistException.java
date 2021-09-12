package com.ganbarli.insurance.exceptions;

public class UserAlreadyExistException extends Exception {

    private String message;

    public UserAlreadyExistException(String s) {
        this.message = s;
    }

    public String getMessage() {
        return message;
    }
}