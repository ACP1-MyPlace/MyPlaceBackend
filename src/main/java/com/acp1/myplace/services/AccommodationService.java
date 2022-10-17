package com.acp1.myplace.services;

import com.acp1.myplace.dto.accommodation.AccommodationRequest;
import com.acp1.myplace.dto.accommodation.AccommodationResponse;

import java.util.List;
import java.util.Map;

public interface AccommodationService {

    AccommodationResponse createAccommodation(AccommodationRequest newAccommodation);

    List<AccommodationResponse> getAccommodations(Map<String, String> queryParams);

    AccommodationResponse getAccommodation(Long accommodationId);

    AccommodationResponse updateAccommodation(Long accommodationId, AccommodationRequest update);

}
