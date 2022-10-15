package com.acp1.myplace.dto.accommodation;

import com.acp1.myplace.domain.accommodation.AccommodationService;
import com.acp1.myplace.domain.accommodation.PropertyType;
import com.acp1.myplace.model.accommodation.Price;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class AccommodationRequest {

    @NotNull private Long userId;

    @NotNull private PropertyType propertyType;

    @NotBlank private String country;

    @NotBlank private String state;

    @NotBlank private String street;

    @NotNull private Integer streetNumber;

    private String floor;

    private String apartment;

    @NotNull private Integer roomsCount;

    @NotNull private Integer bathroomCount;

    @NotNull private boolean garageAvailable;

    @NotNull private boolean petsAvailable;

    @NotNull private List<AccommodationService> services;

    @NotNull private Price price;
}
