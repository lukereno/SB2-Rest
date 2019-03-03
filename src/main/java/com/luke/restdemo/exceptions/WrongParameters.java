package com.luke.restdemo.exceptions;

public class WrongParameters extends RuntimeException {

    public WrongParameters() {
    }

    public WrongParameters(String message) {
        super(message);
    }

}