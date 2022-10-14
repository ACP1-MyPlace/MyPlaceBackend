package com.acp1.myplace.dto;

import com.acp1.myplace.domain.AccommodationService;
import com.acp1.myplace.domain.PropertyType;
import com.acp1.myplace.model.Price;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class AccommodationDTO {

    @NotNull private PropertyType propertyType;

    @NotBlank private String country;

    @NotBlank private String state;

    @NotBlank private String street;

    @NotNull private Integer streetNumber;

    private String floor;

    private String apartment;

    @NotNull private Integer roomsCount;

    @NotNull private Integer bathroomCount;

    @NotNull private Boolean garage;

    @NotNull private Boolean petsAvailable;

    @NotNull private List<AccommodationService> services;

    @NotNull private Price price;
}
