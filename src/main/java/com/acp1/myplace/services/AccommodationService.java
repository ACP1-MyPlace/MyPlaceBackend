package com.acp1.myplace.services;

import com.acp1.myplace.dto.accommodation.AccommodationRequest;
import com.acp1.myplace.dto.accommodation.AccommodationResponse;

import org.springframework.data.domain.Pageable;
import com.acp1.myplace.model.user.User;


import java.util.List;

public interface AccommodationService {

    AccommodationResponse createAccommodation(AccommodationRequest newAccommodation);

    List<AccommodationResponse> getAccommodations(Pageable queryParams);

    AccommodationResponse getAccommodation(Long accommodationId);

    AccommodationResponse updateAccommodation(Long accommodationId, AccommodationRequest update);

    void deleteAccomodationById(Long accommodationId);

    List<AccommodationResponse> getAccommodationsFromUser(User user);
}
