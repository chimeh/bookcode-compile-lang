package smarthome.orders;

import smarthome.drivers.Stereo;

public class TurnOnCDStereoOrder implements Order{

    private Stereo stereo;

    public TurnOnCDStereoOrder(Stereo stereo) {
        this.stereo = stereo;
    }

    public void execute() {
        stereo.turnOn();
        stereo.setCD();
        stereo.setVolume();
    }

    public void undo() {
        stereo.turnOff();
    }
}
