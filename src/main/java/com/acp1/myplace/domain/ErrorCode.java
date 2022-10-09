package com.acp1.myplace.domain;

public enum ErrorCode {
    
    VALIDATION_ERROR(-1), 
    REGISTER_ERROR(-2);

    private int codeId;

    ErrorCode(int code){
        this.codeId = code;
    }

    public int getCodeId(){
        return this.codeId;
    }

}
