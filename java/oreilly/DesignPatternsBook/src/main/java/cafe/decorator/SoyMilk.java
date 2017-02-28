package cafe.decorator;

public class SoyMilk extends Garnish{

    private Drink coffee;

    public SoyMilk(Drink coffee) {
        this.coffee = coffee;
    }

    public Size getSize(){
        return coffee.getSize();
    }

    public String getDescription(){
        return coffee.getDescription() + ", soy milk";
    }

    private double calculatePrize(){
        double cost = 1d;

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
