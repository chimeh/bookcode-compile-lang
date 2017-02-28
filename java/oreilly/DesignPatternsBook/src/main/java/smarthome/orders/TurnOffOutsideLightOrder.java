package smarthome.orders;

import smarthome.drivers.OutsideLight;

public class TurnOffOutsideLightOrder implements Order {

    private OutsideLight light;

    public TurnOffOutsideLightOrder(OutsideLight light) {
        this.light = light;
    }

    public void execute() {
        light.turnOff();
    }

    public void undo() {
        light.turnOn();
    }
}
