package smarthome.orders;

import smarthome.drivers.CeilingFan;

public class MediumSpeedCeilingFanOrder implements Order{

    CeilingFan ceilingFan;
    int lastSpeed;

    public MediumSpeedCeilingFanOrder(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    public void execute() {
        lastSpeed = ceilingFan.getSpeed();
        ceilingFan.mediumSpeed();
    }

    public void undo() {
        switch (lastSpeed){
            case 3:
                ceilingFan.highSpeed();
                break;
            case 2:
                ceilingFan.mediumSpeed();
                break;
            case 1:
                ceilingFan.lowSpeed();
                break;
            case 0:
                ceilingFan.turnOff();
                break;
            default:
                ceilingFan.turnOff();
        }
    }
}
