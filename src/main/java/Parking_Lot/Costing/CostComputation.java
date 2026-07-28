package Parking_Lot.Costing;

import Parking_Lot.Entities.Ticket;

public class CostComputation {
    private final CostingStrategy costingStrategy;

    public CostComputation(CostingStrategy costingStrategy) {
        this.costingStrategy = costingStrategy;
    }

    public int calculateCost(Ticket ticket) {
        return costingStrategy.calculateCost(ticket);
    }
}