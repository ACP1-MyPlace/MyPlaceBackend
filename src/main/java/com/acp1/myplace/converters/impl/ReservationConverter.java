package com.acp1.myplace.converters.impl;

import com.acp1.myplace.converters.Converter;
import com.acp1.myplace.dto.reservation.ReservationResponse;
import com.acp1.myplace.dto.user.UserResponse;
import com.acp1.myplace.model.reservation.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReservationConverter implements Converter<Reservation, ReservationResponse> {

    @Autowired
    private AccommodationConverter accommodationConverter;

    @Override
    public ReservationResponse apply(Reservation reservation) {
        return ReservationResponse.builder()
                .id(reservation.getId())
                .user(UserResponse.builder()
                        .id(reservation.getUser().getUserId())
                        .mail(reservation.getUser().getEmail())
                        .firstName(reservation.getUser().getFirstName())
                        .lastName(reservation.getUser().getLastName())
                        .type(reservation.getUser().getType())
                        .build())
                .accommodation(accommodationConverter.apply(reservation.getAccommodation()))
                .startingDate(reservation.getStartingDate())
                .finishingDate(reservation.getFinishingDate())
                .paymentMethod(reservation.getPaymentMethod())
                .price(reservation.getPrice())
                .status(reservation.getStatus())
                .build();
    }

    @Override
    public Reservation revert(ReservationResponse to) {
        return null;
    }
}
