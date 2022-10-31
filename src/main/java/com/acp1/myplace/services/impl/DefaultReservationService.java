package com.acp1.myplace.services.impl;

import com.acp1.myplace.converters.impl.*;
import com.acp1.myplace.domain.reservation.ReservationStatus;
import com.acp1.myplace.dto.reservation.ReservationRequest;
import com.acp1.myplace.dto.reservation.ReservationResponse;
import com.acp1.myplace.entities.AccommodationEntity;
import com.acp1.myplace.entities.ReservationEntity;
import com.acp1.myplace.exceptions.AccommodationAlreadyReservedException;
import com.acp1.myplace.model.accommodation.Accommodation;
import com.acp1.myplace.model.reservation.Reservation;
import com.acp1.myplace.model.user.User;
import com.acp1.myplace.repositories.AccommodationRepository;
import com.acp1.myplace.repositories.ReservationRepository;
import com.acp1.myplace.services.AccommodationService;
import com.acp1.myplace.services.ReservationService;
import com.acp1.myplace.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class DefaultReservationService implements ReservationService {

    @Autowired
    private ReservationRequestConverter reservationRequestConverter;

    @Autowired
    private ReservationEntityConverter reservationEntityConverter;

    @Autowired
    private ReservationConverter reservationConverter;

    @Autowired
    private UserService userService;

    @Autowired
    private AccommodationService accommodationService;

    @Autowired
    private AccommodationConverter accommodationConverter;

    @Autowired
    private AccommodationEntityConverter accommodationEntityConverter;

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public List<ReservationResponse> getReservationsFromUser(User user) {
        List<Reservation> model = this.reservationEntityConverter.apply( this.reservationRepository.findAll());
        model.removeIf(a -> a.getUser().getUserId() !=  user.getUserId() );
        return this.reservationConverter.apply(model);
    }

    @Override
    public List<ReservationResponse> getReservationsFromHost(User host) {
        List<Reservation> model = this.reservationEntityConverter.apply( this.reservationRepository.findAll());
        model.removeIf(a -> a.getAccommodation().getUser().getUserId() !=  host.getUserId() );
        return this.reservationConverter.apply(model);
    }

    private void checkReservationDates(LocalDateTime startingDate, LocalDateTime finishingDate, Long accommodationId){
        List<ReservationEntity> reservations = reservationRepository.findByAccommodationIdAndStartingDateBetween(accommodationId, startingDate, finishingDate);
        if(! reservations.isEmpty()){
            throw new AccommodationAlreadyReservedException();
        }

        reservations = reservationRepository.findByAccommodationIdAndFinishingDateBetween(accommodationId, startingDate, finishingDate);
        if(! reservations.isEmpty()){
            throw new AccommodationAlreadyReservedException();
        }
    }

    @Override
    public ReservationResponse createReservation(ReservationRequest newReservation) {
        checkReservationDates(newReservation.getStartingDate(), newReservation.getFinishingDate(), newReservation.getAccommodationId());
        newReservation.setStatus(ReservationStatus.PENDING);
        Reservation reservation = this.reservationRequestConverter.apply(newReservation);
        User user = this.userService.getUserById(reservation.getUser().getUserId());
        ReservationEntity reservationEntity = this.reservationEntityConverter.revert(reservation);
        AccommodationEntity accommodationEntity = accommodationService.getAccommodation(reservation.getAccommodation().getId());

        reservationEntity.setUser(user);
        reservationEntity.setAccommodation(accommodationEntity);
        ReservationEntity created = this.reservationRepository.save(reservationEntity);
        Reservation reservationCreated = this.reservationEntityConverter.apply(created);
        return this.reservationConverter.apply(reservationCreated);
    }

    @Override
    public ReservationResponse updateReservation(Long reservationId, ReservationRequest update) {
        checkReservationDates(update.getStartingDate(), update.getFinishingDate(), update.getAccommodationId());

        Reservation reservationUpdate = this.reservationRequestConverter.apply(update);
        ReservationEntity reservationEntityUpdate = this.reservationEntityConverter.revert(reservationUpdate);
        reservationEntityUpdate.setId(reservationId);
        User user = this.userService.getUserById(update.getUserId());
        AccommodationEntity accommodationEntity = accommodationService.getAccommodation(update.getAccommodationId());

        reservationEntityUpdate.setUser(user);
        reservationEntityUpdate.setAccommodation(accommodationEntity);
        ReservationEntity updated = this.reservationRepository.save(reservationEntityUpdate);
        Reservation reservationUpdated = this.reservationEntityConverter.apply(updated);
        return this.reservationConverter.apply(reservationUpdated);
    }
}
