package com.acp1.myplace.exceptions;

import com.acp1.myplace.domain.ErrorCode;

public class AccommodationNotFoundException extends ServiceException {
    public AccommodationNotFoundException() {
        super("Accomodation not found", ErrorCode.NOT_FOUND);
    }
}
