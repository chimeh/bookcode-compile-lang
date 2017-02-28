package cafe.decorator;

public class Main {

    public static void main(String[] args) {

        Drink drink2 = new Strong();
        drink2.setSize(Size.LARGE);
        drink2 = new SoyMilk(drink2);
        drink2 = new Chocolate(drink2);
        System.out.println(drink2.getDescription() + ", " + drink2.getSize() + "; Cost: " + drink2.cost() + "$");
    }
}
