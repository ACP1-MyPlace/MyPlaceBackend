package com.acp1.myplace.services;

import com.acp1.myplace.dto.AccommodationRequest;
import com.acp1.myplace.dto.AccommodationResponse;

import java.util.List;

public interface AccommodationService {

    AccommodationResponse createAccommodation(AccommodationRequest newAccommodation);

    List<AccommodationResponse> getAccommodations();

    AccommodationResponse getAccommodation(Long accommodationId);

    AccommodationResponse updateAccommodation(Long accommodationId, AccommodationRequest update);

}
