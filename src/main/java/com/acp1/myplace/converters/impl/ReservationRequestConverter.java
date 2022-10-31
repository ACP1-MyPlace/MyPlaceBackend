package com.acp1.myplace.converters.impl;

import com.acp1.myplace.converters.Converter;
import com.acp1.myplace.domain.reservation.ReservationStatus;
import com.acp1.myplace.dto.reservation.ReservationRequest;
import com.acp1.myplace.model.accommodation.Accommodation;
import com.acp1.myplace.model.reservation.Reservation;
import com.acp1.myplace.model.user.User;
import org.springframework.stereotype.Component;

@Component
public class ReservationRequestConverter implements Converter<ReservationRequest, Reservation> {

    private static final Long NEW_RESERVATION_ID = 0L;

    @Override
    public Reservation apply(ReservationRequest reservationRequest) {
        return Reservation.builder()
                .id(NEW_RESERVATION_ID)
                .user(User.builder().userId(reservationRequest.getUserId()).build())
                .accommodation(Accommodation.builder().id(reservationRequest.getAccommodationId()).build())
                .startingDate(reservationRequest.getStartingDate())
                .finishingDate(reservationRequest.getFinishingDate())
                .paymentMethod(reservationRequest.getPaymentMethod())
                .price(reservationRequest.getPrice())
                .status(reservationRequest.getStatus())
                .build();

    }

    @Override
    public ReservationRequest revert(Reservation to) {
        return null;
    }
}
