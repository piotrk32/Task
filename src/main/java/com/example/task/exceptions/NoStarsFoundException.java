package com.example.task.exceptions;

public class NoStarsFoundException extends RuntimeException {
    public NoStarsFoundException(String message) {
        super(message);
    }
}