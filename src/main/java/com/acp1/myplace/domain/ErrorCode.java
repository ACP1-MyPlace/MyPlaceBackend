package com.acp1.myplace.domain;

public enum ErrorCode {
    
    VALIDATION_ERROR(-1), 
    REGISTER_ERROR(-2),
    USER_NOT_HOST(-100),
    NOT_FOUND(404);

    private int codeId;

    ErrorCode(int code){
        this.codeId = code;
    }

    public int getCodeId(){
        return this.codeId;
    }

}
