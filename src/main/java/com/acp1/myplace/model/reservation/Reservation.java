package com.acp1.myplace.model.reservation;

import com.acp1.myplace.domain.reservation.PaymentMethod;
import com.acp1.myplace.domain.reservation.ReservationStatus;
import com.acp1.myplace.model.accommodation.Accommodation;
import com.acp1.myplace.model.accommodation.Price;
import com.acp1.myplace.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Reservation {
    @NotNull
    private Long id;

    @NotNull
    private User user;

    @NotNull
    private Accommodation accommodation;

    @NotNull
    private LocalDateTime startingDate;

    @NotNull
    private LocalDateTime finishingDate;

    @NotNull
    private PaymentMethod paymentMethod;

    @NotNull
    private Price price;

    @NotNull
    private ReservationStatus status;

}
