package smarthome.orders;

import smarthome.drivers.TapDriver;

public class TurnOnTapDriverOrder implements Order {

    private TapDriver tapDriver;

    public TurnOnTapDriverOrder(TapDriver light) {
        this.tapDriver = light;
    }

    public void execute() {
        tapDriver.openValve();
    }

    public void undo() {
        tapDriver.closeValve();
    }
}
