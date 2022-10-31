package com.acp1.myplace.exceptions;

import com.acp1.myplace.domain.ErrorCode;

public class AccommodationAlreadyReservedException extends ServiceException{
    public AccommodationAlreadyReservedException(){
        super("Accomodation already reserved in dates given", ErrorCode.NOT_FOUND);
    }
}
