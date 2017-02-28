package cafe.decorator;

public class Cream extends Garnish{

    private Drink coffee;

    public Cream(Drink coffee) {
        this.coffee = coffee;
    }

    public String getDescription(){
        return coffee.getDescription() + ", cream";
    }

    public Size getSize(){
        return coffee.getSize();
    }

    private double calculatePrize(){
        double cost = 1.5d;

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
