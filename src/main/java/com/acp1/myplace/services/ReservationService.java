package com.acp1.myplace.services;

import com.acp1.myplace.dto.reservation.ReservationRequest;
import com.acp1.myplace.dto.reservation.ReservationResponse;
import com.acp1.myplace.model.user.User;

import java.util.List;

public interface ReservationService {

    List<ReservationResponse> getReservationsFromUser(User user);

    List<ReservationResponse> getReservationsFromHost(User host);

    ReservationResponse createReservation(ReservationRequest newReservation);

    ReservationResponse updateReservation(Long reservationId, ReservationRequest update);

}
