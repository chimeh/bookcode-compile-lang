package smarthome.orders;

import smarthome.drivers.GarageDoors;

public class OpenGarageDoorsOrder implements Order{

    private GarageDoors garageDoors;

    public OpenGarageDoorsOrder(GarageDoors garageDoors) {
        this.garageDoors = garageDoors;
    }

    public void execute() {
        garageDoors.up();
        garageDoors.lightOn();
        garageDoors.stop();
    }

    public void undo() {
        garageDoors.lightOff();
    }
}
