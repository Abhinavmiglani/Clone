package com.samplewebapp.backend.exception;

public class CustomException extends RuntimeException{
    public CustomException(){
        super("Creating an customexception");
    }
}
