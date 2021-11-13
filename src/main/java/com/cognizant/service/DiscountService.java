package com.cognizant.service;

import java.math.BigDecimal;

public interface DiscountService {

    default BigDecimal getBusDiscount() {
        return new BigDecimal("0.02");
    }

}
