package com.acp1.myplace.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.acp1.myplace.exceptions.ServiceException;
import com.acp1.myplace.exceptions.UserAlreadyRegistered;
import com.acp1.myplace.exceptions.UserNotFoundException;
import com.acp1.myplace.handlers.responses.ErrorResponse;

@ControllerAdvice
public class ServiceHandler {
    
    @ResponseBody
    @ExceptionHandler(UserAlreadyRegistered.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    ErrorResponse handleServiceException(UserAlreadyRegistered ex) {
        return new ErrorResponse(ex.getCode(), ex.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ErrorResponse handleServiceException(UserNotFoundException ex) {
        return new ErrorResponse(ex.getCode(), ex.getMessage());
    }
}
