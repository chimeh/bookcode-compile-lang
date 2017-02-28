package smarthome.orders;

import smarthome.drivers.Light;

public class TurnOffLightOrder implements Order{

    private Light light;

    public TurnOffLightOrder(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOff();
    }

    public void undo() {
        light.turnOn();
    }
}
