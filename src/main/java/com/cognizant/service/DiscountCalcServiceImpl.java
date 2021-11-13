package com.cognizant.service;

import com.cognizant.domain.Trip;
import com.cognizant.domain.VehicleType;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;

public class DiscountCalcServiceImpl implements DiscountCalcService {

    private final DiscountService discountService;

    public DiscountCalcServiceImpl(DiscountService discountService) {
        this.discountService = discountService;
    }

    @Override
    public BigDecimal calculateDiscount(Trip trip) {
        if (trip.getVehicle().getType() == VehicleType.BUS) {
            return discountService.getBusDiscount();
        } else {
            return ZERO;
        }
    }

}
