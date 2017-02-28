package com.designpatterns.chp1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Duck {

    final static Logger logger = LoggerFactory.getLogger(Duck.class);

    public void setFlyBehaviour(FlyBehaviour flyBehaviour) {
        this.flyBehaviour = flyBehaviour;
    }

    public void setQuackBehavior(QuackBehaviour quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    FlyBehaviour flyBehaviour;
    QuackBehaviour quackBehavior;

    public Duck(){

    }

    public abstract void display();

    public void performFly() {
        flyBehaviour.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public void swim() {
        logger.info("All ducks float, even decoys!");
    }

}
