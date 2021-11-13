package com.cognizant.domain;

import java.util.List;

public class Route {

    private List<Destination> destinations;

    public Route(List<Destination> destinations) {
        this.destinations = destinations;
    }

    public List<Destination> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<Destination> destinations) {
        this.destinations = destinations;
    }
}
