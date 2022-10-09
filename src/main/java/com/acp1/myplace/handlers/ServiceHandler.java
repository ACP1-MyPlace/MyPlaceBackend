package com.acp1.myplace.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.acp1.myplace.exceptions.ServiceException;
import com.acp1.myplace.handlers.responses.ErrorResponse;

@ControllerAdvice
public class ServiceHandler {
    
    @ResponseBody
    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    ErrorResponse handleServiceException(ServiceException ex) {
        return new ErrorResponse(ex.getCode(), ex.getMessage());
    }

}
