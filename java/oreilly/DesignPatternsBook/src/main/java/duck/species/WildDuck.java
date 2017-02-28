package duck.species;

import duck.fly.FlyWithWings;
import duck.quack.Quacking;

public class WildDuck extends Duck {

    public WildDuck() {
        quackInterface = new Quacking();
        flyInterface = new FlyWithWings();
    }

    public void display() {
        System.out.println("wild_duck.jpg");
    }
}
