package com.acp1.myplace.model.accommodation;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Currency {

    private String currencyId;

    private String currencyName;
}
