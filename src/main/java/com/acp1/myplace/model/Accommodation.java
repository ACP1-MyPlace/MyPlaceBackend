package com.acp1.myplace.model;

import com.acp1.myplace.domain.AccommodationService;
import com.acp1.myplace.domain.PropertyType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Accommodation {

    @NotNull
    private Long id;

    @NotNull
    private PropertyType propertyType;

    @NotNull
    private String country;

    @NotNull
    private String state;

    @NotNull
    private String street;

    @NotNull
    private Integer streetNumber;

    private String floor;

    private String apartment;

    @NotNull
    private Integer roomsCount;

    @NotNull
    private Integer bathroomCount;

    @NotNull
    private boolean garageAvailable;

    @NotNull
    private boolean petsAvailable;

    @NotNull
    private List<AccommodationService> services;

    @NotNull
    private Price price;

}
