package com.acp1.myplace.repositories;

import com.acp1.myplace.entities.AccommodationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccommodationRepository extends JpaRepository<AccommodationEntity, Long> {
}
