package com.acp1.myplace.dto.reservation;

import com.acp1.myplace.domain.reservation.PaymentMethod;
import com.acp1.myplace.domain.reservation.ReservationStatus;
import com.acp1.myplace.dto.accommodation.AccommodationResponse;
import com.acp1.myplace.dto.user.UserResponse;
import com.acp1.myplace.model.accommodation.Price;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class ReservationResponse {
    @NotNull
    private Long id;

    @NotNull
    private UserResponse user;

    @NotNull
    private AccommodationResponse accommodation;

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
