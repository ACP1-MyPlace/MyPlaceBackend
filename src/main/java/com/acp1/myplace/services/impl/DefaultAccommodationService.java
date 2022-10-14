package com.acp1.myplace.services.impl;

import com.acp1.myplace.dto.AccommodationDTO;
import com.acp1.myplace.entities.AccommodationEntity;
import com.acp1.myplace.entities.AccommodationServiceEntity;
import com.acp1.myplace.model.Accommodation;
import com.acp1.myplace.repositories.AccommodationRepository;
import com.acp1.myplace.repositories.AccommodationServiceRepository;
import com.acp1.myplace.services.AccommodationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class DefaultAccommodationService implements AccommodationService {

    private static final Long NEW_ACCOMMODATION_ID = 0L;

    @Autowired
    private AccommodationRepository accommodationRepository;

    @Autowired
    private AccommodationServiceRepository accommodationServiceRepository;

    @Override
    public Accommodation createAccommodation(AccommodationDTO newAccommodation) {
        Accommodation accommodation = this.dtoToModel(newAccommodation);
        AccommodationEntity accommodationEntity = this.modelToEntity(accommodation);
        accommodationRepository.save(accommodationEntity);
        List<AccommodationServiceEntity> accommodationServiceEntities = this.modelToServiceEntities(accommodation);
        accommodationServiceRepository.saveAll(accommodationServiceEntities);
        return accommodation;
    }

    @Override
    public List<Accommodation> getAccommodations() {
        return null;
    }

    @Override
    public Accommodation getAccommodation(Long accommodationId) {
        return null;
    }

    @Override
    public Accommodation updateAccommodation(Long accommodationId, AccommodationDTO update) {
        return null;
    }

    private Accommodation dtoToModel(AccommodationDTO accommodationDTO) {
        return Accommodation.builder().id(NEW_ACCOMMODATION_ID)
                .propertyType(accommodationDTO.getPropertyType())
                .country(accommodationDTO.getCountry())
                .state(accommodationDTO.getState())
                .street(accommodationDTO.getStreet())
                .streetNumber(accommodationDTO.getStreetNumber())
                .floor(accommodationDTO.getFloor())
                .apartment(accommodationDTO.getApartment())
                .roomsCount(accommodationDTO.getRoomsCount())
                .bathroomCount(accommodationDTO.getBathroomCount())
                .garage(accommodationDTO.isGarageAvailable())
                .petsAvailable(accommodationDTO.isPetsAvailable())
                .services(accommodationDTO.getServices())
                .price(accommodationDTO.getPrice()).build();
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

    private List<AccommodationServiceEntity> modelToServiceEntities(Accommodation accommodation) {
        Long accommodationId = accommodation.getId();
        return accommodation.getServices().stream()
                .map(service -> AccommodationServiceEntity.builder().accommodationId(accommodationId).service(service).build())
                .collect(Collectors.toList());
    }
}
