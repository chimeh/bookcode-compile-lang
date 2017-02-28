package smarthome.orders;

import smarthome.drivers.Stereo;

public class TurnOffStereoOrder implements Order {

    private Stereo stereo;

    public TurnOffStereoOrder(Stereo stereo) {
        this.stereo = stereo;
    }

    public void execute() {
        stereo.turnOff();
    }

    public void undo() {
        stereo.turnOn();
    }
}
