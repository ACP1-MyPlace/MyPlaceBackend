package com.acp1.myplace.services;

import com.acp1.myplace.dto.accommodation.AccommodationRequest;
import com.acp1.myplace.dto.accommodation.AccommodationResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AccommodationService {

    AccommodationResponse createAccommodation(AccommodationRequest newAccommodation);

    List<AccommodationResponse> getAccommodations(Pageable queryParams);

    AccommodationResponse getAccommodation(Long accommodationId);

    AccommodationResponse updateAccommodation(Long accommodationId, AccommodationRequest update);

}
