package com.acp1.myplace.entities;

import com.acp1.myplace.domain.AccommodationService;
import com.acp1.myplace.domain.PropertyType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Singular;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "accommodations")
public class AccommodationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column @NotNull
    private PropertyType propertyType;

    @Column @NotNull
    private String country;

    @Column @NotNull
    private String state;

    @Column @NotNull
    private String street;

    @Column @NotNull
    private Integer streetNumber;

    @Column
    private String floor;

    @Column
    private String apartment;

    @Column @NotNull
    private Integer roomsCount;

    @Column @NotNull
    private Integer bathroomCount;

    @Column @NotNull
    private boolean garageAvailable;

    @Column @NotNull
    private boolean petsAvailable;

    @NotNull
    private String priceCurrencyId;

    @NotNull
    private Long priceAmount;

    @ElementCollection
    @CollectionTable(name = "accommodation_services",
                     joinColumns = @JoinColumn(name = "accommodation_id",referencedColumnName = "id")
    )
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "service", nullable = false)
    List<AccommodationService> services = new ArrayList<>();

}
