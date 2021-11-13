package com.cognizant.service;

import com.cognizant.domain.Trip;
import com.cognizant.domain.Vehicle;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;

public class RateCalcServiceImpl implements RateCalcService {

    private final ACRateService acRateService;
    private final AdditionalChargesService additionalChargesService;
    private final FuelRateService fuelRateService;

    public RateCalcServiceImpl(ACRateService acRateService, AdditionalChargesService additionalChargesService, FuelRateService fuelRateService) {
        this.acRateService = acRateService;
        this.additionalChargesService = additionalChargesService;
        this.fuelRateService = fuelRateService;
    }

    @Override
    public BigDecimal calculateRate(Trip trip) {
        Vehicle vehicle = trip.getVehicle();

        BigDecimal ratePerKm = countFuelRate(vehicle);

        if (vehicle.isAC()) {
            ratePerKm = ratePerKm.add(acRateService.getACRate());
        }

        return ratePerKm.add(countPassengersLimitCharges(trip));
    }

    private BigDecimal countFuelRate(Vehicle vehicle) {
        return switch (vehicle.getFuelType()) {
            case DIESEL -> fuelRateService.getDieselRate();
            case PETROL -> fuelRateService.getPetrolRate();
        };
    }

    private BigDecimal countPassengersLimitCharges(Trip trip) {
        if (trip.getPassengersCount() > trip.getVehicle().getPassengersLimit()) {
            return additionalChargesService.getPassengersLimitCharges()
                    .multiply(new BigDecimal(trip.getPassengersCount()));
        } else {
            return ZERO;
        }
    }
}
