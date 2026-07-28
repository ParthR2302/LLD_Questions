package Parking_Lot;

import java.util.*;

import Parking_Lot.Costing.CostComputation;
import Parking_Lot.Costing.FixedCostingStrategy;
import Parking_Lot.Entities.ParkingSpot;
import Parking_Lot.Entities.Ticket;
import Parking_Lot.Entities.Vehicle;
import Parking_Lot.Enums.VehicleType;
import Parking_Lot.LookupStrategies.ParkingSpotLookupStrategy;
import Parking_Lot.LookupStrategies.RandomLookupStrategy;
import Parking_Lot.Managers.FourWheelerSpotManager;
import Parking_Lot.Managers.ParkingSpotManager;
import Parking_Lot.Managers.TwoWheelerSpotManager;
import Parking_Lot.ParkingLot.EntranceGate;
import Parking_Lot.ParkingLot.ExitGate;
import Parking_Lot.ParkingLot.ParkingBuilding;
import Parking_Lot.ParkingLot.ParkingLevel;
import Parking_Lot.ParkingLot.ParkingLot;
import Parking_Lot.Payment.CardPayment;
import Parking_Lot.Payment.CashPayment;

public class ParkingLotClient {

    public static void main(String[] args) {

        ParkingSpotLookupStrategy strategy = new RandomLookupStrategy();

        Map<VehicleType, ParkingSpotManager> levelOneManagers = new HashMap<>();
        levelOneManagers.put(VehicleType.TWO_WHEELER,
                new TwoWheelerSpotManager(List.of(new ParkingSpot("L1-S1"),
                        new ParkingSpot("L1-S2")), strategy));

        levelOneManagers.put(VehicleType.FOUR_WHEELER,
                new FourWheelerSpotManager(List.of(new ParkingSpot("L1-S3")), strategy));

        ParkingLevel level1 = new ParkingLevel(
                1, levelOneManagers
        );

        Map<VehicleType, ParkingSpotManager> levelTwoManagers = new HashMap<>();
        levelTwoManagers.put(VehicleType.TWO_WHEELER,
                new TwoWheelerSpotManager(List.of(new ParkingSpot("L2-S1")), strategy));

        levelTwoManagers.put(VehicleType.FOUR_WHEELER,
                new FourWheelerSpotManager(List.of(new ParkingSpot("L2-S2"),
                        new ParkingSpot("L2-S3")), strategy));


        ParkingLevel level2 = new ParkingLevel(
                2, levelTwoManagers
        );

        ParkingBuilding parkingBuilding =
                new ParkingBuilding(
                        List.of(level1, level2));

        ParkingLot parkingLot = new ParkingLot(
                parkingBuilding,
                new EntranceGate(),
                new ExitGate(new CostComputation(new FixedCostingStrategy()))
        );


        Vehicle bike = new Vehicle("BIKE-101", VehicleType.TWO_WHEELER);
        Vehicle car = new Vehicle("CAR-201", VehicleType.FOUR_WHEELER);

        Ticket t1 = parkingLot.vehicleArrives(bike);
        Ticket t2 = parkingLot.vehicleArrives(car);

        parkingLot.vehicleDeparts(t1, new CashPayment());
        parkingLot.vehicleDeparts(t2, new CardPayment());
    }
}
