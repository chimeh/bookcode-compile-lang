package smarthome;

import smarthome.drivers.GarageDoors;
import smarthome.drivers.Light;
import smarthome.orders.OpenGarageDoorsOrder;
import smarthome.orders.Order;
import smarthome.orders.TurnOnLightOrder;

public class MiniPilotTest {

    public static void main(String[] args) {

        SmallPilot pilot = new SmallPilot();

        Light kitchenLight = new Light();
        Order turnOnKitchenLight = new TurnOnLightOrder(kitchenLight);

        GarageDoors doors = new GarageDoors();
        Order openGarageDoors = new OpenGarageDoorsOrder(doors);

        pilot.setSlot(turnOnKitchenLight);
        pilot.pressedButton();

        pilot.setSlot(openGarageDoors);
        pilot.pressedButton();
    }
}
