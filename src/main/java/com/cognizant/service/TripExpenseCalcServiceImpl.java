package com.cognizant.service;

import com.cognizant.domain.Trip;

import java.math.BigDecimal;

public class TripExpenseCalcServiceImpl implements TripExpenseCalcService {

    private final RateCalcService rateCalcService;
    private final DiscountCalcService discountCalcService;
    private final DistanceLengthCalcService distanceLengthCalcService;

    public TripExpenseCalcServiceImpl(RateCalcService rateCalcService, DiscountCalcService discountCalcService, DistanceLengthCalcService distanceLengthCalcService) {
        this.rateCalcService = rateCalcService;
        this.discountCalcService = discountCalcService;
        this.distanceLengthCalcService = distanceLengthCalcService;
    }

    @Override
    public BigDecimal calculateExpense(Trip trip) {
        BigDecimal ratePerKm = rateCalcService.calculateRate(trip);
        BigDecimal discount = discountCalcService.calculateDiscount(trip);
        int distanceKm = distanceLengthCalcService.calculateDistanceLength(trip.getRoute());

        return calculateExpense(ratePerKm, discount, distanceKm);
    }

    private BigDecimal calculateExpense(BigDecimal ratePerKm, BigDecimal discount, int distanceKm) {
        BigDecimal totalCost = ratePerKm.multiply(new BigDecimal(distanceKm));
        discount = totalCost.multiply(discount);
        return totalCost.subtract(discount);
    }

}
