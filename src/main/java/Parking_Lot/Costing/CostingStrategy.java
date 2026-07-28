package Parking_Lot.Costing;

import Parking_Lot.Entities.Ticket;

public interface CostingStrategy {

    public int calculateCost(Ticket ticket);
}
