package com.acp1.myplace.handlers.responses;

import java.time.Instant;

import com.acp1.myplace.domain.ErrorCode;

import lombok.Getter;

@Getter
public class ErrorResponse {
    
    private Instant timestamp;
    private ErrorCode code;
    private int codeId;
    private String description;

    public ErrorResponse(ErrorCode code, String description) {
        this.timestamp = Instant.now();
        this.code = code;
        this.codeId = code.getCodeId();
        this.description = description;
    }
}
