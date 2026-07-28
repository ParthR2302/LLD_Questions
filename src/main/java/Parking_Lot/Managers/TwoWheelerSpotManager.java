package Parking_Lot.Managers;

import java.util.List;

import Parking_Lot.Entities.ParkingSpot;
import Parking_Lot.LookupStrategies.ParkingSpotLookupStrategy;

public class TwoWheelerSpotManager extends ParkingSpotManager {
    public TwoWheelerSpotManager(List<ParkingSpot> spots, ParkingSpotLookupStrategy lookupStrategy) {
        super(spots, lookupStrategy);
    }
}
