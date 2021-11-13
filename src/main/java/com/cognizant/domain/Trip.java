package com.cognizant.domain;

public class Trip {

    private Vehicle vehicle;
    private int passengersCount;
    private Route route;

    public Trip(Vehicle vehicle, int passengersCount, Route route) {
        this.vehicle = vehicle;
        this.passengersCount = passengersCount;
        this.route = route;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public int getPassengersCount() {
        return passengersCount;
    }

    public void setPassengersCount(int passengersCount) {
        this.passengersCount = passengersCount;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}
