package com.acp1.myplace.entities;

import com.acp1.myplace.domain.PropertyType;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Builder
@RequiredArgsConstructor
@Table(name = "accommodations")
public class AccommodationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column @NotNull
    private final PropertyType propertyType;

    @Column @NotNull
    private final String country;

    @Column @NotNull
    private final String state;

    @Column @NotNull
    private final String street;

    @Column @NotNull
    private final Integer streetNumber;

    @Column
    private String floor;

    @Column
    private String apartment;

    @Column @NotNull
    private final Integer roomsCount;

    @Column @NotNull
    private final Integer bathroomCount;

    @Column @NotNull
    private final boolean garageAvailable;

    @Column @NotNull
    private final boolean petsAvailable;

    @NotNull
    private final String priceCurrencyId;

    @NotNull
    private final Long priceAmount;

}
