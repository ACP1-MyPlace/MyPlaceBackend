package com.acp1.myplace.handlers;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.acp1.myplace.domain.ErrorCode;
import com.acp1.myplace.handlers.responses.ErrorResponse;

import org.springframework.http.HttpStatus;

@ControllerAdvice
public class ValidationHandler {

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorResponse invalidRequestData(MethodArgumentNotValidException ex) {
        var error = ex.getFieldError();
        if(error == null){
            return new ErrorResponse(ErrorCode.VALIDATION_ERROR, "Validation error");
        }
        var description = "Validation error - '" + error.getRejectedValue() + "' not a valid value for " + error.getField();
        return new ErrorResponse(ErrorCode.VALIDATION_ERROR, description);
    }

}
