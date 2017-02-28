package smarthome.orders;

import smarthome.drivers.TV;

public class TurnOffTVOrder implements Order {

    private TV tv;

    public TurnOffTVOrder(TV tv) {
        this.tv = tv;
    }

    public void execute() {
        tv.turnOff();
    }

    public void undo() {
        tv.turnOn();
    }
}
