package com.acp1.myplace.controllers;

import com.acp1.myplace.domain.user.UserType;
import com.acp1.myplace.dto.accommodation.AccommodationRequest;
import com.acp1.myplace.dto.accommodation.AccommodationResponse;
import com.acp1.myplace.dto.reservation.ReservationRequest;
import com.acp1.myplace.dto.reservation.ReservationResponse;
import com.acp1.myplace.model.user.User;
import com.acp1.myplace.services.AccommodationService;
import com.acp1.myplace.services.JwtManager;
import com.acp1.myplace.services.ReservationService;
import com.acp1.myplace.services.UserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/reservations")
public class ReservationController {

    
    private static final int TOKEN_START = 7;
    
    private AccommodationService accommodationService;

    private final JwtManager jwtManager;

    private UserService userService;

    private ReservationService reservationService;

    public ReservationController(AccommodationService accommodationService, JwtManager jwtManager, UserService userService, ReservationService reservationService) {
        this.accommodationService = accommodationService;
        this.jwtManager = jwtManager;
        this.userService = userService;
        this.reservationService = reservationService;
    }

    @PostMapping("")
    public ReservationResponse addReservation(@RequestBody @Valid ReservationRequest requestDTO) {
        return this.reservationService.createReservation(requestDTO);
    }

    @PutMapping("/{id}")
    public ReservationResponse updateReservationStatus(@RequestBody ReservationRequest requestDTO, @PathVariable Long id) {
        return this.reservationService.updateReservation(id, requestDTO);
    }

    @GetMapping("/myreservations")
    public List<ReservationResponse> getMyReservation(@RequestHeader(value="Authorization") String authorizationHeader){
        String email = null;

        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
            var token = authorizationHeader.substring(TOKEN_START);
            email = jwtManager.getMailFromToken(token);
        }

        User user = userService.getUserByMail(email);
        List<ReservationResponse> reservations = null;
        if (user.getType().equals(UserType.HOST_USER)){
            reservations = this.reservationService.getReservationsFromHost(user);
        }else if (user.getType().equals(UserType.TRAVELER_USER)){
            reservations = this.reservationService.getReservationsFromUser(user);
        }
        return reservations;
    }
}
