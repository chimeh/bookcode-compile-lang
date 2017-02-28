package cafe.decorator;

public class Milk extends Garnish{

    private Drink coffee;

    public Milk(Drink coffee) {
        this.coffee = coffee;
    }

    public String getDescription(){
        return coffee.getDescription() + ", milk";
    }

    public Size getSize(){
        return coffee.getSize();
    }

    private double calculatePrize(){
        double cost = 0.5d;

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
