package com.acp1.myplace.services.impl;

import com.acp1.myplace.dto.AccommodationRequest;
import com.acp1.myplace.dto.AccommodationResponse;
import com.acp1.myplace.entities.AccommodationEntity;
import com.acp1.myplace.entities.AccommodationServiceEntity;
import com.acp1.myplace.model.Accommodation;
import com.acp1.myplace.repositories.AccommodationRepository;
import com.acp1.myplace.services.AccommodationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DefaultAccommodationService implements AccommodationService {

    private static final Long NEW_ACCOMMODATION_ID = 0L;

    @Autowired
    private AccommodationRepository accommodationRepository;

    @Override
    public AccommodationResponse createAccommodation(AccommodationRequest newAccommodation) {
        Accommodation accommodation = this.requestToModel(newAccommodation);
        AccommodationEntity accommodationEntity = this.modelToEntity(accommodation);
        AccommodationEntity created = accommodationRepository.save(accommodationEntity);
        accommodation.setId(created.getId());
        return this.responseToModel(accommodation);
    }

    @Override
    public List<AccommodationResponse> getAccommodations() {
        return null;
    }

    @Override
    public AccommodationResponse getAccommodation(Long accommodationId) {
        return null;
    }

    @Override
    public AccommodationResponse updateAccommodation(Long accommodationId, AccommodationRequest update) {
        return null;
    }

    private Accommodation requestToModel(AccommodationRequest accommodationRequest) {
        return Accommodation.builder().id(NEW_ACCOMMODATION_ID)
                .propertyType(accommodationRequest.getPropertyType())
                .country(accommodationRequest.getCountry())
                .state(accommodationRequest.getState())
                .street(accommodationRequest.getStreet())
                .streetNumber(accommodationRequest.getStreetNumber())
                .floor(accommodationRequest.getFloor())
                .apartment(accommodationRequest.getApartment())
                .roomsCount(accommodationRequest.getRoomsCount())
                .bathroomCount(accommodationRequest.getBathroomCount())
                .garage(accommodationRequest.isGarageAvailable())
                .petsAvailable(accommodationRequest.isPetsAvailable())
                .services(accommodationRequest.getServices())
                .price(accommodationRequest.getPrice()).build();
    }

    private AccommodationEntity modelToEntity(Accommodation accommodation) {
        return AccommodationEntity.builder().propertyType(accommodation.getPropertyType())
                .country(accommodation.getCountry())
                .state(accommodation.getState())
                .street(accommodation.getStreet())
                .streetNumber(accommodation.getStreetNumber())
                .floor(accommodation.getFloor())
                .apartment(accommodation.getApartment())
                .roomsCount(accommodation.getRoomsCount())
                .bathroomCount(accommodation.getBathroomCount())
                .garageAvailable(accommodation.isGarage())
                .petsAvailable(accommodation.isPetsAvailable())
                .priceCurrencyId(accommodation.getPrice().getCurrency().getCurrencyId())
                .priceAmount(accommodation.getPrice().getAmount())
                .build();
    }

    private List<AccommodationServiceEntity> modelToServiceEntities(Accommodation accommodation, AccommodationEntity accommodationEntity) {
        return accommodation.getServices().stream()
                .map(service -> AccommodationServiceEntity.builder().build())
                .collect(Collectors.toList());
    }

    private AccommodationResponse responseToModel(Accommodation accommodation) {
        return AccommodationResponse.builder().id(accommodation.getId())
                .country(accommodation.getCountry())
                .state(accommodation.getState())
                .street(accommodation.getStreet())
                .streetNumber(accommodation.getStreetNumber())
                .floor(accommodation.getFloor())
                .apartment(accommodation.getApartment())
                .roomsCount(accommodation.getRoomsCount())
                .bathroomCount(accommodation.getBathroomCount())
                .garageAvailable(accommodation.isGarage()).build();
    }
}
