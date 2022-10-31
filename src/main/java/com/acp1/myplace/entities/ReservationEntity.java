package com.acp1.myplace.entities;

import com.acp1.myplace.domain.reservation.PaymentMethod;
import com.acp1.myplace.domain.reservation.ReservationStatus;
import com.acp1.myplace.model.accommodation.Price;
import com.acp1.myplace.model.user.User;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reservation")
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "accommodation_id", referencedColumnName = "id")
    private AccommodationEntity accommodation;

    @Column @NotNull
    private LocalDateTime startingDate;

    @Column @NotNull
    private LocalDateTime finishingDate;

    @Column @NotNull
    private PaymentMethod paymentMethod;

    @Column @NotNull
    private String priceCurrencyId;
    
    @Column @NotNull
    private Long priceAmount;

    @Column @NotNull
    private ReservationStatus status;

}
