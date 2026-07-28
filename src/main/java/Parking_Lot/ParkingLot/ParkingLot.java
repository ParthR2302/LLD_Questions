package Parking_Lot.ParkingLot;

import Parking_Lot.Entities.Ticket;
import Parking_Lot.Entities.Vehicle;
import Parking_Lot.Payment.Payment;

public class ParkingLot {
    private final ParkingBuilding parkingBuilding;
    private final EntranceGate entranceGate;
    private final ExitGate exitGate;

    public ParkingLot(ParkingBuilding parkingBuilding, EntranceGate entranceGate, ExitGate exitGate) {
        this.parkingBuilding = parkingBuilding;
        this.entranceGate = entranceGate;
        this.exitGate = exitGate;
    }

    public Ticket vehicleArrives(Vehicle vehicle) {
        return entranceGate.enter(parkingBuilding, vehicle);
    }

    public void vehicleDeparts(Ticket ticket, Payment paymentMethod) {
        exitGate.completeExit(parkingBuilding, ticket, paymentMethod);
    }
}
