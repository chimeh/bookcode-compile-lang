package com.designpatterns.chp4;

import org.slf4j.Logger;

import java.util.ArrayList;

public  abstract class Pizza implements IPizza {

    protected Logger logger;

    String dough;
    String sauce;
    String name;

    ArrayList toppings = new ArrayList();

    @Override
    public void prepare() {
        logger.info("Preparing " + name);
        logger.info("Tossing dough... " + dough);
        logger.info("Adding sauce... " + sauce);
        logger.info("Adding toppings: ");
        for (int i=0; i < toppings.size(); i++) {
            logger.info("   " + toppings.get(i));
        }
    }

    @Override
    public void bake() {
        logger.info("Bake for 25 minutes at 350");
    }

    @Override
    public void cut() {
        logger.info("Cutting the Pizza into diagonal slices");
    }

    @Override
    public void box() {
        logger.info("Place Pizza in official PizzaStore box");
    }

    public String getName() {
        return name;
    }
}
