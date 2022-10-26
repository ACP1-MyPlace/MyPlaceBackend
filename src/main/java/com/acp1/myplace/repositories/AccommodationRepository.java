package com.acp1.myplace.repositories;

import com.acp1.myplace.dto.accommodation.AccommodationResponse;
import com.acp1.myplace.entities.AccommodationEntity;
import com.acp1.myplace.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccommodationRepository extends JpaRepository<AccommodationEntity, Long> {
}
