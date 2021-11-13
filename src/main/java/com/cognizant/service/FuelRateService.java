package com.cognizant.service;

import java.math.BigDecimal;

public interface FuelRateService {

    default BigDecimal getPetrolRate() {
        return new BigDecimal("1.5");
    }

    default BigDecimal getDieselRate() {
        return new BigDecimal("1.4");
    }

}
