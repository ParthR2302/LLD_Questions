package Parking_Lot.Costing;

import Parking_Lot.Entities.Ticket;

public class FixedCostingStrategy implements CostingStrategy {

    @Override
    public int calculateCost(Ticket ticket) {
        return 100;
    }
    
}
