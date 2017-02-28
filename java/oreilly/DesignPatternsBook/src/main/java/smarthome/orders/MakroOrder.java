package smarthome.orders;

public class MakroOrder implements Order {

    Order[] orders;

    public MakroOrder(Order[] orders) {
        this.orders = orders;
    }

    public void execute() {
        for (Order order : orders) {
            order.execute();
        }
    }

    public void undo() {
        for (Order order : orders) {
            order.undo();
        }
    }
}
