package com.acp1.myplace.converters.impl;

import com.acp1.myplace.converters.Converter;
import com.acp1.myplace.domain.accommodation.CurrencyType;
import com.acp1.myplace.entities.AccommodationEntity;
import com.acp1.myplace.entities.ReservationEntity;
import com.acp1.myplace.model.accommodation.Accommodation;
import com.acp1.myplace.model.accommodation.Price;
import com.acp1.myplace.model.reservation.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReservationEntityConverter  implements Converter<ReservationEntity, Reservation> {

    @Autowired
    private AccommodationEntityConverter accommodationEntityConverter;

    @Override
    public Reservation apply(ReservationEntity reservationEntity) {
        return Reservation.builder()
                .id(reservationEntity.getId())
                .user(reservationEntity.getUser())
                .accommodation(accommodationEntityConverter.apply(reservationEntity.getAccommodation()))
                .startingDate(reservationEntity.getStartingDate())
                .finishingDate(reservationEntity.getFinishingDate())
                .paymentMethod(reservationEntity.getPaymentMethod())
                .price(Price.builder()
                        .amount(reservationEntity.getPriceAmount())
                        .currency(CurrencyType.fromCurrencyId(reservationEntity.getPriceCurrencyId()).getCurrency())
                        .build())
                .status(reservationEntity.getStatus())
                .build();
    }

    @Override
    public ReservationEntity revert(Reservation reservation) {
        AccommodationEntity accommodation = null;
        if(reservation.getAccommodation().getUser() != null){
            accommodation = accommodationEntityConverter.revert(reservation.getAccommodation());
        }
        return ReservationEntity.builder()
                .id(reservation.getId())
                .user(reservation.getUser())
                .accommodation(accommodation)
                .startingDate(reservation.getStartingDate())
                .finishingDate(reservation.getFinishingDate())
                .paymentMethod(reservation.getPaymentMethod())
                .priceAmount(reservation.getPrice().getAmount())
                .priceCurrencyId(reservation.getPrice().getCurrency().getCurrencyId())
                .status(reservation.getStatus())
                .build();
    }
}
