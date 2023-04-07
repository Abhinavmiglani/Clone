package com.samplewebapp.backend.exception;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class ExceptionsAdvice {


    @ResponseBody
    @ExceptionHandler(NoSuchUserException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String exceptionHandler(NoSuchUserException exception){

        for(int i=0; i<100;i++)
        {
            log.error("Creating an customer not found error");

        }
        return exception.getMessage();


    }

    @ResponseBody
    @ExceptionHandler(CustomException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String customExceptionHandler(CustomException exception){

        for(int i=0; i<100;i++)
        {
            log.error("Creating an custom error");

        }
        return exception.getMessage();



    }

}
