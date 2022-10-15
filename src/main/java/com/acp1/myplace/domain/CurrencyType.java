package com.acp1.myplace.domain;

import com.acp1.myplace.model.Currency;

public enum CurrencyType {

    USD("USD", "Dolares");

    private Currency currency;

    private CurrencyType(String currencyId, String currencyName){
        this.currency = Currency.builder().currencyId(currencyId).currencyName(currencyName).build();
    }

    public Currency getCurrency() {
        return currency;
    }

    public static CurrencyType fromCurrencyId(String currencyId) {
        for (CurrencyType value: CurrencyType.values()) {
            if (value.name().equals(currencyId)) {
                return value;
            }
        }
        return null;
    }
}
