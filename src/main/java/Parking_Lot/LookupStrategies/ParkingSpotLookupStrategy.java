package Parking_Lot.LookupStrategies;

import java.util.List;

import Parking_Lot.Entities.ParkingSpot;

public interface ParkingSpotLookupStrategy {
    ParkingSpot selectSpot(List<ParkingSpot> spots);
}
