package com.acp1.myplace.entities;

import com.acp1.myplace.domain.AccommodationService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Builder
@AllArgsConstructor
@Embeddable
public class AccommodationServiceEntity {

    @Enumerated(EnumType.ORDINAL)
    private AccommodationService service;
}
