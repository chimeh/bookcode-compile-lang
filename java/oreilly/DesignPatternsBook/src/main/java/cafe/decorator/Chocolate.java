package cafe.decorator;

public class Chocolate extends Garnish{

    private Drink coffee;

    public Chocolate(Drink coffee) {
        this.coffee = coffee;
    }

    public Size getSize(){
        return coffee.getSize();
    }

    public String getDescription(){
        return coffee.getDescription() + ", chocolate";
    }

    private double calculatePrize(){
        double cost = 0.75d;

        switch (getSize()){
            case LARGE:
                cost += 0.2;
                break;
            case MEDIUM:
                cost += 0.1;
                break;
            case SMALL:
                cost -= 0.1;
                break;
        }
        return cost;
    }

    public double cost() {
        return calculatePrize() + coffee.cost();
    }
}
