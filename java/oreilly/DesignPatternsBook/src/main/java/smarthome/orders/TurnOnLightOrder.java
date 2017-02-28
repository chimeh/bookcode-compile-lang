package smarthome.orders;

import smarthome.drivers.Light;

public class TurnOnLightOrder implements Order{

    private Light light;

    public TurnOnLightOrder(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOn();
    }

    public void undo() {
        light.turnOff();
    }
}
