package com.cognizant.service;

import com.cognizant.domain.Destination;

import java.util.List;

import static com.cognizant.domain.Destination.*;

public interface DistanceService {

    //  Assume that distance is the same for both directions
    default int getDistance(Destination destination1, Destination destination2) {
        List<Destination> destinations = List.of(destination1, destination2);
        if (destinations.contains(PRAGUE) && destinations.contains(BRNO)) {
            return 200;
        } else if (destinations.contains(PRAGUE) && destinations.contains(BUDAPEST)) {
            return 550;
        } else if (destinations.contains(BRNO) && destinations.contains(VIENA)) {
            return 150;
        } else if (destinations.contains(BRNO) && destinations.contains(BUDAPEST)) {
            return 350;
        } else {
            throw new RuntimeException(String.format("Distance is unknown for %s - %s", destination1, destination2));
        }
    }

}
