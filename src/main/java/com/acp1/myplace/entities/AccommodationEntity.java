package com.acp1.myplace.entities;

import com.acp1.myplace.domain.accommodation.AccommodationService;
import com.acp1.myplace.domain.accommodation.PropertyType;
import com.acp1.myplace.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "accommodations")
public class AccommodationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private User user;

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
                     joinColumns = @JoinColumn(name = "accommodation_id", referencedColumnName = "id")
    )
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "service", nullable = false)
    List<AccommodationService> services = new ArrayList<>();

}
