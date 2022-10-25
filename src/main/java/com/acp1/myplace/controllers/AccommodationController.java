package com.acp1.myplace.controllers;

import com.acp1.myplace.dto.accommodation.AccommodationRequest;
import com.acp1.myplace.dto.accommodation.AccommodationResponse;
import com.acp1.myplace.model.user.User;
import com.acp1.myplace.services.AccommodationService;
import com.acp1.myplace.services.JwtManager;
import com.acp1.myplace.services.UserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/accommodations")
public class AccommodationController {
    private AccommodationService accommodationService;

    private final JwtManager jwtManager;

    private UserService userService;

    public AccommodationController(AccommodationService accommodationService, JwtManager jwtManager, UserService userService) {
        this.accommodationService = accommodationService;
        this.jwtManager = jwtManager;
        this.userService = userService;
    }

    @PostMapping("")
    public AccommodationResponse addAccommodation(@RequestBody @Valid AccommodationRequest requestDTO) {
        return this.accommodationService.createAccommodation(requestDTO);
    }

    @GetMapping("")
    public List<AccommodationResponse> addAccommodation() {
        return this.accommodationService.getAccommodations();
    }

    @DeleteMapping("/{id}")
    public void deleteAccomodation(@PathVariable Long id) {
        this.accommodationService.deleteAccomodationById(id);
    }

    @PutMapping("/{id}")
    public AccommodationResponse updateAccommodation(@RequestBody AccommodationRequest requestDTO, @PathVariable Long id) {
        return this.accommodationService.updateAccommodation(id, requestDTO);
    }

    @GetMapping("/myaccomodations")
    public List<AccommodationResponse> getMyAccomodations(@RequestHeader(value="auth") String userToken){
        String email = jwtManager.getMailFromToken(userToken);
        User user = userService.getUserByMail(email);
        return this.accommodationService.getAccommodationsFromUser(user);
    }
}
