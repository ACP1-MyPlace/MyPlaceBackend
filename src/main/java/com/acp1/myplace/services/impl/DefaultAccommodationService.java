package com.acp1.myplace.services.impl;

import com.acp1.myplace.converters.impl.AccommodationEntityConverter;
import com.acp1.myplace.converters.impl.AccommodationRequestConverter;
import com.acp1.myplace.converters.impl.AccommodationConverter;
import com.acp1.myplace.dto.accommodation.AccommodationRequest;
import com.acp1.myplace.dto.accommodation.AccommodationResponse;
import com.acp1.myplace.entities.AccommodationEntity;
import com.acp1.myplace.model.accommodation.Accommodation;
import com.acp1.myplace.repositories.AccommodationRepository;
import com.acp1.myplace.services.AccommodationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DefaultAccommodationService implements AccommodationService {

    @Autowired
    private AccommodationRequestConverter  accommodationRequestConverter;

    @Autowired
    private AccommodationEntityConverter accommodationEntityConverter;

    @Autowired
    private AccommodationConverter accommodationConverter;

    @Autowired
    private AccommodationRepository accommodationRepository;

    @Override
    public AccommodationResponse createAccommodation(AccommodationRequest newAccommodation) {
        Accommodation accommodation = this.accommodationRequestConverter.apply(newAccommodation);
        AccommodationEntity accommodationEntity = this.accommodationEntityConverter.revert(accommodation);
        AccommodationEntity created = accommodationRepository.save(accommodationEntity);
        accommodation.setId(created.getId());
        return this.accommodationConverter.apply(accommodation);
    }

    @Override
    public List<AccommodationResponse> getAccommodations() {
        List<Accommodation> model = this.accommodationEntityConverter.apply(this.accommodationRepository.findAll());
        return this.accommodationConverter.apply(model);
    }

    @Override
    public AccommodationResponse getAccommodation(Long accommodationId) {
        return null;
    }

    @Override
    public AccommodationResponse updateAccommodation(Long accommodationId, AccommodationRequest update) {
        return null;
    }

}
