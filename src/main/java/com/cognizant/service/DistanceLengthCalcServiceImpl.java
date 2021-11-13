package com.cognizant.service;

import com.cognizant.domain.Destination;
import com.cognizant.domain.Route;

import java.util.List;

public class DistanceLengthCalcServiceImpl implements DistanceLengthCalcService {

    private final DistanceService distanceService;

    public DistanceLengthCalcServiceImpl(DistanceService distanceService) {
        this.distanceService = distanceService;
    }

    @Override
    public int calculateDistanceLength(Route route) {
        int kilometers = 0;
        List<Destination> destinations = route.getDestinations();

        for (int i = 0; i < destinations.size() - 1; i++) {
            Destination destination1 = destinations.get(i);
            Destination destination2 = destinations.get(i + 1);

            kilometers += distanceService.getDistance(destination1, destination2);
        }

        return kilometers;
    }
}
