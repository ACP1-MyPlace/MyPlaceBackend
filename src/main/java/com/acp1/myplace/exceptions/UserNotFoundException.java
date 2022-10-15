package com.acp1.myplace.exceptions;

import com.acp1.myplace.domain.ErrorCode;

public class UserNotFoundException extends ServiceException {
    public UserNotFoundException() {
        super("User not found", ErrorCode.NOT_FOUND);
    }
}
