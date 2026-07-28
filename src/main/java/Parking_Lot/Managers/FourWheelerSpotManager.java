package Parking_Lot.Managers;

import java.util.List;

import Parking_Lot.Entities.ParkingSpot;
import Parking_Lot.LookupStrategies.ParkingSpotLookupStrategy;

public class FourWheelerSpotManager extends ParkingSpotManager {
    public FourWheelerSpotManager(List<ParkingSpot> spots, ParkingSpotLookupStrategy lookupStrategy) {
        super(spots, lookupStrategy);
    }
    
}
