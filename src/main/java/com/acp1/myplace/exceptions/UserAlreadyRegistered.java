package com.acp1.myplace.exceptions;

import com.acp1.myplace.domain.ErrorCode;

public class UserAlreadyRegistered extends ServiceException {

    public UserAlreadyRegistered() {
        super("User already signed up",ErrorCode.REGISTER_ERROR);
    }
    

}
