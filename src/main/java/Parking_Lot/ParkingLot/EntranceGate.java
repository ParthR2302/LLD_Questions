package Parking_Lot.ParkingLot;

import Parking_Lot.Entities.Ticket;
import Parking_Lot.Entities.Vehicle;

public class EntranceGate {
    public Ticket enter(ParkingBuilding parkingBuilding, Vehicle vehicle) { return parkingBuilding.parkVehicle(vehicle); }
}
