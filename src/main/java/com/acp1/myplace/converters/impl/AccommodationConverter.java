package com.acp1.myplace.converters.impl;

import com.acp1.myplace.converters.Converter;
import com.acp1.myplace.dto.accommodation.AccommodationResponse;
import com.acp1.myplace.dto.user.UserResponse;
import com.acp1.myplace.model.accommodation.Accommodation;
import org.springframework.stereotype.Component;

@Component
public class AccommodationConverter implements Converter<Accommodation, AccommodationResponse> {
    @Override
    public AccommodationResponse apply(Accommodation accommodation) {
        return AccommodationResponse.builder()
                .id(accommodation.getId())
                .host(UserResponse.builder()
                        .mail(accommodation.getUser().getEmail())
                        .firstName(accommodation.getUser().getFirstName())
                        .lastName(accommodation.getUser().getLastName())
                        .type(accommodation.getUser().getType())
                        .build())
                .propertyType(accommodation.getPropertyType())
                .country(accommodation.getCountry())
                .state(accommodation.getState())
                .street(accommodation.getStreet())
                .streetNumber(accommodation.getStreetNumber())
                .floor(accommodation.getFloor())
                .apartment(accommodation.getApartment())
                .roomsCount(accommodation.getRoomsCount())
                .bathroomCount(accommodation.getBathroomCount())
                .garageAvailable(accommodation.isGarageAvailable())
                .services(accommodation.getServices())
                .price(accommodation.getPrice())
                .description(accommodation.getDescription())
                .build();
    }

    @Override
    public Accommodation revert(AccommodationResponse to) {
        return null;
    }
}
