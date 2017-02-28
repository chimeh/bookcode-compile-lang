package cafe.wrong;

public class Espresso extends Drink{

    public Espresso() {
        description = "Very strong coffee from Italy";
    }

    @Override
    public double Cost(){

        double cost = super.Cost();
        cost += 1;

        if(isMilk()){
            cost += 0.5d;
        } else if(isSoyMilk()){
            cost += 1.0d;
        } else if(isChocolate()){
            cost += 0.75d;
        } else if(isCream()){
            cost += 1.5d;
        }

        return cost;
    }
}
