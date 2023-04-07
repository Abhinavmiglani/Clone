package com.samplewebapp.backend.exception;

public class NoSuchUserException extends RuntimeException{
    public NoSuchUserException(Long id){
        super("Could not found the user with id "+ id);
    }
}
