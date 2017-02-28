package duck.species;

import duck.fly.CannotFly;
import duck.quack.Quacking;

public class DuckModel extends Duck {

    public DuckModel(){
        quackInterface = new Quacking();
        flyInterface = new CannotFly();
    }

    public void display() {
        System.out.println("duck_model.jpg");
    }
}
