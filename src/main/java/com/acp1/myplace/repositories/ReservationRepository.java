package com.acp1.myplace.repositories;

import com.acp1.myplace.entities.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {
    List<ReservationEntity> findByAccommodationIdAndStartingDateBetween(Long accommodationId, LocalDateTime startingDate, LocalDateTime finishingDate);

    List<ReservationEntity> findByAccommodationIdAndFinishingDateBetween(Long accommodationId, LocalDateTime startingDate, LocalDateTime finishingDate);
}
