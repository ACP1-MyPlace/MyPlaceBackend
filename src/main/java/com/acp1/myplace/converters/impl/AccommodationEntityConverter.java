package com.acp1.myplace.converters.impl;

import com.acp1.myplace.converters.Converter;
import com.acp1.myplace.domain.accommodation.CurrencyType;
import com.acp1.myplace.entities.AccommodationEntity;
import com.acp1.myplace.model.accommodation.Accommodation;
import com.acp1.myplace.model.accommodation.Price;
import org.springframework.stereotype.Component;

@Component
public class AccommodationEntityConverter implements Converter<AccommodationEntity, Accommodation> {
    @Override
    public Accommodation apply(AccommodationEntity accommodationEntity) {
        return Accommodation.builder()
                .id(accommodationEntity.getId())
                .user(accommodationEntity.getUser())
                .propertyType(accommodationEntity.getPropertyType())
                .country(accommodationEntity.getCountry())
                .state(accommodationEntity.getState())
                .street(accommodationEntity.getStreet())
                .streetNumber(accommodationEntity.getStreetNumber())
                .floor(accommodationEntity.getFloor())
                .apartment(accommodationEntity.getApartment())
                .roomsCount(accommodationEntity.getRoomsCount())
                .bathroomCount(accommodationEntity.getBathroomCount())
                .garageAvailable(accommodationEntity.isGarageAvailable())
                .petsAvailable(accommodationEntity.isPetsAvailable())
                .services(accommodationEntity.getServices())
                .price(Price.builder()
                        .amount(accommodationEntity.getPriceAmount())
                        .currency(CurrencyType.fromCurrencyId(accommodationEntity.getPriceCurrencyId()).getCurrency())
                        .build())
                .description(accommodationEntity.getDescription())
                .build();
    }

    @Override
    public AccommodationEntity revert(Accommodation accommodation) {
        return AccommodationEntity.builder().propertyType(accommodation.getPropertyType())
                .user(accommodation.getUser())
                .country(accommodation.getCountry())
                .state(accommodation.getState())
                .street(accommodation.getStreet())
                .streetNumber(accommodation.getStreetNumber())
                .floor(accommodation.getFloor())
                .apartment(accommodation.getApartment())
                .roomsCount(accommodation.getRoomsCount())
                .bathroomCount(accommodation.getBathroomCount())
                .garageAvailable(accommodation.isGarageAvailable())
                .petsAvailable(accommodation.isPetsAvailable())
                .services(accommodation.getServices())
                .priceCurrencyId(accommodation.getPrice().getCurrency().getCurrencyId())
                .priceAmount(accommodation.getPrice().getAmount())
                .description(accommodation.getDescription())
                .build();
    }
}
