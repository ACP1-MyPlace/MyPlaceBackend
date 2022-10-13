package com.acp1.myplace.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Price {

    private Currency currency;

    private Long amount;
}
