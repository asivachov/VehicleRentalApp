package com.cognizant.domain;

public class Vehicle {

    private String name;
    private VehicleType type;
    private int passengersLimit;
    private boolean hasAC;
    private FuelType fuelType;

    public Vehicle(String name, VehicleType type, int passengersLimit, boolean hasAC, FuelType fuelType) {
        this.name = name;
        this.type = type;
        this.passengersLimit = passengersLimit;
        this.hasAC = hasAC;
        this.fuelType = fuelType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public int getPassengersLimit() {
        return passengersLimit;
    }

    public void setPassengersLimit(int passengersLimit) {
        this.passengersLimit = passengersLimit;
    }

    public boolean isAC() {
        return hasAC;
    }

    public void setHasAC(boolean hasAC) {
        this.hasAC = hasAC;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }
}
