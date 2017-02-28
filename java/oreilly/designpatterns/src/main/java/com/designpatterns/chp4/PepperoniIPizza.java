package com.designpatterns.chp4;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PepperoniIPizza implements IPizza {
    private static final Logger logger = LoggerFactory.getLogger(PepperoniIPizza.class);

    @Override
    public void prepare() {
        logger.info("Preparing pepperoni Pizza");
    }

    @Override
    public void bake() {
        logger.info("Baking pepperoni Pizza");
    }

    @Override
    public void cut() {
        logger.info("Pepperoni Pizza sliced and diced");
    }

    @Override
    public void box() {
        logger.info("Pepperoni Pizza boxed and ready for pick-up/delivery");
    }
}
