package smarthome;

import smarthome.orders.Order;

public class SmallPilot {

    Order slot;

    public SmallPilot() {
    }

    public void setSlot(Order order) {
        this.slot = order;
    }

    public void pressedButton(){
        slot.execute();
    }
}
