package smarthome;

import smarthome.orders.NoOrder;
import smarthome.orders.Order;

public class SuperPilot {

    private Order[] turnOn;
    private Order[] turnOff;
    private Order lastOrder;

    public SuperPilot() {
        Order noOrder = new NoOrder();

        turnOn = new Order[7];
        turnOff = new Order[7];
        lastOrder = noOrder;

        for (int i = 0; i < 7; i++) {
            turnOn[i] = noOrder;
            turnOff[i] = noOrder;
        }
    }

    public void setOrder(int slot, Order turnOnOrder, Order turnOffOrder) {
        turnOn[slot] = turnOnOrder;
        turnOff[slot] = turnOffOrder;
    }

    public void onButtonPressed(int slot) {
        turnOn[slot].execute();
        lastOrder = turnOn[slot];
    }

    public void offButtonPressed(int slot) {
        turnOff[slot].execute();
        lastOrder = turnOff[slot];
    }

    public void undoButtonPressed(){
        lastOrder.undo();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\n----------SUPER PILOT--------------\n");
        for (int i=0; i<turnOn.length; i++){
            builder.append("slot [" + i +  "] " + turnOn[i].getClass().getName() +
            " | " + turnOff[i].getClass().getName() + "\n");
        }
        builder.append("undo [" + lastOrder.getClass().getName() + "]");

        return builder.toString();
    }
}
