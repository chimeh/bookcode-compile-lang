package smarthome.orders;

import smarthome.drivers.Jacuzzi;

public class TurnOnJacuzziOrder implements Order{

    private Jacuzzi jacuzzi;

    public TurnOnJacuzziOrder(Jacuzzi jacuzzi) {
        this.jacuzzi = jacuzzi;
    }

    public void execute() {
        jacuzzi.setTemperature();
        jacuzzi.turnOnCirculation();
        jacuzzi.turnOnBubbles();
    }

    public void undo() {
        jacuzzi.turnOffBubbles();
    }
}
