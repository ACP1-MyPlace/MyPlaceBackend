package com.acp1.myplace.converters.impl;

import com.acp1.myplace.converters.Converter;
import com.acp1.myplace.dto.accommodation.AccommodationResponse;
import com.acp1.myplace.dto.user.UserResponse;
import com.acp1.myplace.model.accommodation.Accommodation;
import com.acp1.myplace.model.user.User;
import org.springframework.stereotype.Component;

@Component
public class AccommodationConverter implements Converter<Accommodation, AccommodationResponse> {
    @Override
    public AccommodationResponse apply(Accommodation accommodation) {
        return AccommodationResponse.builder()
                .id(accommodation.getId())
                .host(UserResponse.builder()
                        .id(accommodation.getId())
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
                .petsAvailable(accommodation.isPetsAvailable())
                .services(accommodation.getServices())
                .price(accommodation.getPrice())
                .description(accommodation.getDescription())
                .build();
    }

    @Override
    public Accommodation revert(AccommodationResponse accommodationResponse) {
        return Accommodation.builder()
                .id(accommodationResponse.getId())
                .user(User.builder()
                        .userId(accommodationResponse.getHost().getId())
                        .email(accommodationResponse.getHost().getMail())
                        .firstName(accommodationResponse.getHost().getFirstName())
                        .lastName(accommodationResponse.getHost().getLastName())
                        .type(accommodationResponse.getHost().getType())
                        .build())
                .propertyType(accommodationResponse.getPropertyType())
                .country(accommodationResponse.getCountry())
                .state(accommodationResponse.getState())
                .street(accommodationResponse.getStreet())
                .streetNumber(accommodationResponse.getStreetNumber())
                .floor(accommodationResponse.getFloor())
                .apartment(accommodationResponse.getApartment())
                .roomsCount(accommodationResponse.getRoomsCount())
                .bathroomCount(accommodationResponse.getBathroomCount())
                .garageAvailable(accommodationResponse.isGarageAvailable())
                .petsAvailable(accommodationResponse.isPetsAvailable())
                .services(accommodationResponse.getServices())
                .price(accommodationResponse.getPrice())
                .description(accommodationResponse.getDescription())
                .build();
    }
}
