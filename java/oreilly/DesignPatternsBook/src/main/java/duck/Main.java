package duck;

import duck.fly.RocketFlying;
import duck.species.Duck;
import duck.species.DuckModel;
import duck.species.WildDuck;

public class Main {

    public static void main(String[] args) {

        Duck testWildDuck = new WildDuck();

        testWildDuck.display();
        testWildDuck.swim();
        testWildDuck.executeFly();
        testWildDuck.executeQuack();

        Duck testModelDuck = new DuckModel();

        testModelDuck.executeQuack();
        testModelDuck.executeFly();

        testModelDuck.setFlyInterface(new RocketFlying());

        testModelDuck.executeFly();
    }
}
