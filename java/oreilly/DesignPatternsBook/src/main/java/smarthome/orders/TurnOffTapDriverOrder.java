package smarthome.orders;

import smarthome.drivers.TapDriver;

public class TurnOffTapDriverOrder implements Order {

    private TapDriver tapDriver;

    public TurnOffTapDriverOrder(TapDriver light) {
        this.tapDriver = light;
    }

    public void execute() {
        tapDriver.closeValve();
    }

    public void undo() {
        tapDriver.openValve();
    }
}
