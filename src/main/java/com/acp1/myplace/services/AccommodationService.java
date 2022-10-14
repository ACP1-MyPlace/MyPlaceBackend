package com.acp1.myplace.services;

import com.acp1.myplace.dto.AccommodationDTO;
import com.acp1.myplace.model.Accommodation;

import java.util.List;

public interface AccommodationService {

    Accommodation createAccommodation(AccommodationDTO newAccommodation);

    List<Accommodation> getAccommodations();

    Accommodation getAccommodation(Long accommodationId);

    Accommodation updateAccommodation(Long accommodationId, AccommodationDTO update);

}
