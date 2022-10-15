package com.acp1.myplace.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Currency {

    private String currencyId;

    private String currencyName;
}
