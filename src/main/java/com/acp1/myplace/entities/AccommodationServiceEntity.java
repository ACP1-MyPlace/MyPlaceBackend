package com.acp1.myplace.entities;

import com.acp1.myplace.domain.AccommodationService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Builder
@AllArgsConstructor
@Table(name = "accommodation_service")
public class AccommodationServiceEntity {

    @Column
    @NotNull
    private Long accommodationId;

    @Column @NotNull
    private AccommodationService service;
}
