package com.cognizant.service;

import java.math.BigDecimal;

public interface ACRateService {

    default BigDecimal getACRate() {
        return new BigDecimal("0.2");
    }

}
