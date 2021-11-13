package com.cognizant.service;

import com.cognizant.domain.Route;
import com.cognizant.domain.Trip;
import com.cognizant.domain.Vehicle;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static com.cognizant.domain.Destination.*;
import static com.cognizant.domain.FuelType.DIESEL;
import static com.cognizant.domain.FuelType.PETROL;
import static com.cognizant.domain.VehicleType.*;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TripExpenseCalcServiceImplTest {

    private final ACRateService acRateService = new ACRateService() {
    };
    private final AdditionalChargesService additionalChargesService = new AdditionalChargesService() {
    };
    private final DiscountService discountService = new DiscountService() {
    };
    private final DistanceService distanceService = new DistanceService() {
    };
    private final FuelRateService fuelRateService = new FuelRateService() {
    };

    private final DistanceLengthCalcService distanceLengthCalcService = new DistanceLengthCalcServiceImpl(distanceService);
    private final DiscountCalcService discountCalcService = new DiscountCalcServiceImpl(discountService);
    private final RateCalcService rateCalcService = new RateCalcServiceImpl(acRateService, additionalChargesService, fuelRateService);

    private final TripExpenseCalcServiceImpl calculator = new TripExpenseCalcServiceImpl(
            rateCalcService,
            discountCalcService,
            distanceLengthCalcService
    );

    private final Route route = new Route(asList(PRAGUE, BRNO, BUDAPEST, PRAGUE));

    @Test
    void testDieselCar() {
        Vehicle vehicle = new Vehicle("VW Golf", CAR, 4, false, DIESEL);
        Trip trip = new Trip(vehicle, 3, route);

        BigDecimal totalExpense = calculator.calculateExpense(trip);

        assertEquals(new BigDecimal(1540).stripTrailingZeros(), totalExpense.stripTrailingZeros());
    }

    @Test
    void testPetrolCar() {
        Vehicle vehicle = new Vehicle("VW Golf", CAR, 4, false, PETROL);
        Trip trip = new Trip(vehicle, 3, route);

        BigDecimal totalExpense = calculator.calculateExpense(trip);

        assertEquals(new BigDecimal(1650).stripTrailingZeros(), totalExpense.stripTrailingZeros());
    }

    @Test
    void testPetrolCarWithAc() {
        Vehicle vehicle = new Vehicle("VW Golf", CAR, 4, true, PETROL);
        Trip trip = new Trip(vehicle, 3, route);

        BigDecimal totalExpense = calculator.calculateExpense(trip);

        assertEquals(new BigDecimal(1870).stripTrailingZeros(), totalExpense.stripTrailingZeros());
    }

    @Test
    void testPetrolCarWithPassengerLimitExceeded() {
        Vehicle vehicle = new Vehicle("VW Golf", CAR, 4, false, PETROL);
        Trip trip = new Trip(vehicle, 5, route);

        BigDecimal totalExpense = calculator.calculateExpense(trip);

        assertEquals(new BigDecimal(2200).stripTrailingZeros(), totalExpense.stripTrailingZeros());
    }

    @Test
    void testPetrolBus() {
        Vehicle vehicle = new Vehicle("Ikarus", BUS, 24, false, PETROL);
        Trip trip = new Trip(vehicle, 12, route);

        BigDecimal totalExpense = calculator.calculateExpense(trip);

        assertEquals(new BigDecimal(1617), totalExpense.stripTrailingZeros());
    }

    @Test
    void testPetrolBusWithPassengerLimitExceededAndWithAc() {
        Vehicle vehicle = new Vehicle("Ikarus", BUS, 24, true, PETROL);
        Trip trip = new Trip(vehicle, 25, route);

        BigDecimal totalExpense = calculator.calculateExpense(trip);

        assertEquals(new BigDecimal("4527.6").stripTrailingZeros(), totalExpense.stripTrailingZeros());
    }

    @Test
    void testPetrolVan() {
        Vehicle vehicle = new Vehicle("Lil van", VAN, 4, false, PETROL);
        Trip trip = new Trip(vehicle, 3, route);

        BigDecimal totalExpense = calculator.calculateExpense(trip);

        assertEquals(new BigDecimal(1650).stripTrailingZeros(), totalExpense.stripTrailingZeros());
    }


    @Test
    void testPetrolSuv() {
        Vehicle vehicle = new Vehicle("Toyota SUV", SUV, 4, false, PETROL);
        Trip trip = new Trip(vehicle, 3, route);

        BigDecimal totalExpense = calculator.calculateExpense(trip);

        assertEquals(new BigDecimal(1650).stripTrailingZeros(), totalExpense.stripTrailingZeros());
    }

}
