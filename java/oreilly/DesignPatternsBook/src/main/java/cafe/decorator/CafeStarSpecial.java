package cafe.decorator;

public class CafeStarSpecial extends Drink{

    public CafeStarSpecial(){
        description = "Special coffee from our chief";
    }

    public double cost(){
        return 2.5d;
    }
}
