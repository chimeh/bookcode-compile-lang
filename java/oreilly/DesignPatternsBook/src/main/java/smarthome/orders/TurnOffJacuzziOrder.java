package smarthome.orders;

import smarthome.drivers.Jacuzzi;

public class TurnOffJacuzziOrder implements Order{

    private Jacuzzi jacuzzi;

    public TurnOffJacuzziOrder(Jacuzzi jacuzzi) {
        this.jacuzzi = jacuzzi;
    }

    public void execute() {
        jacuzzi.turnOffBubbles();
    }

    public void undo() {
        jacuzzi.setTemperature();
        jacuzzi.turnOnCirculation();
        jacuzzi.turnOnBubbles();
    }
}
