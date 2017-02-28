package smarthome.drivers;

public class CeilingFan {

    public static final int FAST = 3;
    public static final int MEDIUM = 2;
    public static final int SLOW = 1;
    public static final int TURN_OFF = 0;
    String localisation;
    int speed;

    public CeilingFan(String localisation) {
        this.localisation = localisation;
        speed = TURN_OFF;
    }

    public void highSpeed() {
        speed = FAST;
        System.out.println( localisation + " high speed turned on");
    }

    public void mediumSpeed() {
        speed = MEDIUM;
        System.out.println(localisation + " medium speed turned on");
    }

    public void lowSpeed() {
        speed = SLOW;
        System.out.println(localisation + " low speed turned on");
    }

    public void turnOff() {
        speed = TURN_OFF;
        System.out.println( localisation + " ceiling fan turned off");
    }

    public int getSpeed() {
        return speed;
    }
}
