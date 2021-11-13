package com.cognizant.service;

import com.cognizant.domain.Trip;

import java.math.BigDecimal;

public interface RateCalcService {

    BigDecimal calculateRate(Trip trip);

}
