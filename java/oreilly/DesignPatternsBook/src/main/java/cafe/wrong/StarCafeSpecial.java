package cafe.wrong;

public class StarCafeSpecial extends Drink {

    public StarCafeSpecial() {
        description = "Special cofe from our chef";
    }

    @Override
    public double Cost() {

        setChocolate(true);
        setCream(true);

        double cost = super.Cost();

        if (isMilk())
            cost += 0.5d;

        if (isSoyMilk())
            cost += 1.0d;

        if (isChocolate())
            cost += 0.75d;

        if (isCream())
            cost += 1.5d;


        return cost;
    }
}
