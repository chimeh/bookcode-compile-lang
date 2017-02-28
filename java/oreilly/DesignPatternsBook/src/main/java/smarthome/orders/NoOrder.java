package smarthome.orders;

public class NoOrder implements Order{

    public void execute() {
        System.out.println("Nothing to do here");
    }

    public void undo() {
        System.out.println("Nothing to undo here");
    }
}
