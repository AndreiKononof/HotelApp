package com.example.HotelApp.exception;

public class UserNameIsNotAvailableException extends RuntimeException {
    public UserNameIsNotAvailableException(String message) {
        super(message);
    }
}
