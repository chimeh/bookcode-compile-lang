package com.designpatterns.chp1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModelDuck extends Duck{

    private Logger logger = LoggerFactory.getLogger(ModelDuck.class);

    public ModelDuck(){
        flyBehaviour = new FlyNoWay();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        logger.info("I'm a model duck");
    }
}
