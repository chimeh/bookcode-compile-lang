package cafe.wrong;

public class Main {

    public static void main(String[] args) {

        Drink starCafeSpecial = new StarCafeSpecial();
        System.out.println(starCafeSpecial.getDescription() + ", Cost: " + starCafeSpecial.Cost() + "$");
    }
}
