package duck.species;

import duck.fly.FlyInterface;
import duck.quack.QuackInterface;

public abstract class Duck {

    protected FlyInterface flyInterface;
    protected QuackInterface quackInterface;

    public Duck(){}

    public void setFlyInterface(FlyInterface flyInterface) {
        this.flyInterface = flyInterface;
    }

    public void setQuackInterface(QuackInterface quackInterface) {
        this.quackInterface = quackInterface;
    }

    public abstract void display();

    public void swim(){
        System.out.println("I can swim");
    }

    public void executeFly(){
        flyInterface.fly();
    }

    public void executeQuack(){
        quackInterface.quack();
    }
}
