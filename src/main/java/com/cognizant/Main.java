package com.cognizant;

import com.cognizant.domain.*;
import com.cognizant.service.*;

import java.math.BigDecimal;

import static com.cognizant.domain.Destination.*;
import static com.cognizant.domain.FuelType.DIESEL;
import static com.cognizant.domain.VehicleType.CAR;
import static java.util.Arrays.asList;

public class Main {

    public static void main(String[] args) {
        ACRateService acRateService = new ACRateService() {};
        AdditionalChargesService additionalChargesService = new AdditionalChargesService() {};
        DiscountService discountService = new DiscountService() {};
        DistanceService distanceService = new DistanceService() {};
        FuelRateService fuelRateService = new FuelRateService() {};

        DistanceLengthCalcService distanceLengthCalcService = new DistanceLengthCalcServiceImpl(distanceService);
        DiscountCalcService discountCalcService = new DiscountCalcServiceImpl(discountService);
        RateCalcService rateCalcService = new RateCalcServiceImpl(acRateService, additionalChargesService, fuelRateService);

        TripExpenseCalcServiceImpl tripExpenseCalcServiceImpl = new TripExpenseCalcServiceImpl(
                rateCalcService,
                discountCalcService,
                distanceLengthCalcService
        );

        Vehicle vehicle = new Vehicle("VW Golf", CAR, 4, false, DIESEL);
        Route route = new Route(asList(PRAGUE, BRNO, BUDAPEST, PRAGUE));
        Trip trip = new Trip(vehicle, 3, route);

        BigDecimal totalExpense = tripExpenseCalcServiceImpl.calculateExpense(trip);
        System.out.println(totalExpense);
    }

}
