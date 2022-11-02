package com.acp1.myplace.converters.impl;

import com.acp1.myplace.converters.Converter;
import com.acp1.myplace.dto.accommodation.AccommodationRequest;
import com.acp1.myplace.model.accommodation.Accommodation;
import com.acp1.myplace.model.user.User;
import org.springframework.stereotype.Component;

@Component
public class AccommodationRequestConverter implements Converter<AccommodationRequest, Accommodation> {

    private static final Long NEW_ACCOMMODATION_ID = 0L;
    @Override
    public Accommodation apply(AccommodationRequest accommodationRequest) {
        return Accommodation.builder()
                .id(NEW_ACCOMMODATION_ID)
                .user(User.builder().userId(accommodationRequest.getUserId()).build())
                .propertyType(accommodationRequest.getPropertyType())
                .country(accommodationRequest.getCountry())
                .state(accommodationRequest.getState())
                .street(accommodationRequest.getStreet())
                .streetNumber(accommodationRequest.getStreetNumber())
                .floor(accommodationRequest.getFloor())
                .apartment(accommodationRequest.getApartment())
                .roomsCount(accommodationRequest.getRoomsCount())
                .bathroomCount(accommodationRequest.getBathroomCount())
                .garageAvailable(accommodationRequest.isGarageAvailable())
                .petsAvailable(accommodationRequest.isPetsAvailable())
                .services(accommodationRequest.getServices())
                .price(accommodationRequest.getPrice())
                .description(accommodationRequest.getDescription())
                .photoIds(accommodationRequest.getPhotoIds())
                .build();
    }

    @Override
    public AccommodationRequest revert(Accommodation to) {
        return null;
    }
}
