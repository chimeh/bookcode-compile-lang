package smarthome.orders;

import smarthome.drivers.OutsideLight;

public class TurnOnOutsideLightOrder implements Order {

    private OutsideLight light;

    public TurnOnOutsideLightOrder(OutsideLight light) {
        this.light = light;
    }

    public void execute() {
        light.turnOn();
    }

    public void undo() {
        light.turnOff();
    }
}
