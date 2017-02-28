package cafe.decorator;

public class Strong extends Drink {

    public Strong() {
        description = "Very intensive coffee from  Brazil";
    }

    public double cost() {
        return 2d;
    }
}
