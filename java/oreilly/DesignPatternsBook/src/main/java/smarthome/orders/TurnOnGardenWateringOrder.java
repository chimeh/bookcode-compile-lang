package smarthome.orders;

import smarthome.drivers.GardenWatering;

public class TurnOnGardenWateringOrder implements Order {

    private GardenWatering gardenWatering;

    public TurnOnGardenWateringOrder(GardenWatering gardenWatering) {
        this.gardenWatering = gardenWatering;
    }

    public void execute() {
        gardenWatering.turnOnWater();
    }

    public void undo() {
        gardenWatering.turnOffWater();
    }
}
