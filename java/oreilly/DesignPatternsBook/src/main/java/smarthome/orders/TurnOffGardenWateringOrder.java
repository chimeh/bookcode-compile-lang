package smarthome.orders;

import smarthome.drivers.GardenWatering;

public class TurnOffGardenWateringOrder implements Order {

    private GardenWatering gardenWatering;

    public TurnOffGardenWateringOrder(GardenWatering gardenWatering) {
        this.gardenWatering = gardenWatering;
    }

    public void execute() {
        gardenWatering.turnOffWater();
    }

    public void undo() {
        gardenWatering.turnOnWater();
    }
}
