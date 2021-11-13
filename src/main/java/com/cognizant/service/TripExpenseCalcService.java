package com.cognizant.service;

import com.cognizant.domain.Trip;

import java.math.BigDecimal;

public interface TripExpenseCalcService {

    BigDecimal calculateExpense(Trip trip);

}
