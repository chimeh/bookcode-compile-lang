package com.designpatterns.chp1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MallardDuck extends Duck {

    Logger logger = LoggerFactory.getLogger(MallardDuck.class);

    @Override
    public void display() {
        logger.info("I'm a real Mallard duck");
    }

    public MallardDuck(){
        quackBehavior = new Quack();
        flyBehaviour = new FlyWithWings();
    }
}
