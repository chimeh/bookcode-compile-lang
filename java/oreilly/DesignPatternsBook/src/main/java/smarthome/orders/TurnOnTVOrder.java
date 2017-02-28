package smarthome.orders;

import smarthome.drivers.TV;

public class TurnOnTVOrder implements Order {

    private TV tv;

    public TurnOnTVOrder(TV tv) {
        this.tv = tv;
    }

    public void execute() {
        tv.turnOn();
        tv.setChannel();
        tv.setVolume();
    }

    public void undo() {
        tv.turnOff();
    }
}
