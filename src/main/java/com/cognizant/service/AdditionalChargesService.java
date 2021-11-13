package com.cognizant.service;

import java.math.BigDecimal;

public interface AdditionalChargesService {

    default BigDecimal getPassengersLimitCharges() {
        return new BigDecimal("0.1");
    }

}
