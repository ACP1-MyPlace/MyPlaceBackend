package com.acp1.myplace.exceptions;

import com.acp1.myplace.domain.ErrorCode;

import lombok.Getter;

@Getter
public class ServiceException extends RuntimeException {
    protected ErrorCode code;

    public ServiceException(String message, ErrorCode code) {
        super(message);
        this.code = code;
    }
}
