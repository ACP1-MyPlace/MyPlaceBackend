package com.acp1.myplace.controllers;

import com.acp1.myplace.dto.accommodation.AccommodationRequest;
import com.acp1.myplace.dto.accommodation.AccommodationResponse;
import com.acp1.myplace.services.AccommodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/accommodations")
public class AccommodationController {
    @Autowired
    private AccommodationService accommodationService;

    @PostMapping("")
    public AccommodationResponse addAccommodation(@RequestBody @Valid AccommodationRequest requestDTO) {
        return this.accommodationService.createAccommodation(requestDTO);
    }

    @GetMapping("")
    public List<AccommodationResponse> addAccommodation() {
        return this.accommodationService.getAccommodations();
    }
}
