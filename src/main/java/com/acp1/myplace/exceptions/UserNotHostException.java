package com.acp1.myplace.exceptions;

import com.acp1.myplace.domain.ErrorCode;

public class UserNotHostException extends ServiceException {

    public UserNotHostException() {
        super("User is not a host", ErrorCode.USER_NOT_HOST);
    }
}
