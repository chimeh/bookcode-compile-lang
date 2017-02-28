package cafe.decorator;

public class Espresso extends Drink{

    public Espresso(){
        description = "Small and strong italian-style coffee";
    }

    public double cost() {
        return 2.25d;
    }
}
