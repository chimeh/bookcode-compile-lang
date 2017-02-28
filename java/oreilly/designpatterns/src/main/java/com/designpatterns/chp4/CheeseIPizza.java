package com.designpatterns.chp4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheeseIPizza implements IPizza {

    private static final Logger logger = LoggerFactory.getLogger(CheeseIPizza.class);

    @Override
    public void prepare() {
       logger.info("Preparing cheese Pizza");
    }

    @Override
    public void bake() {
        logger.info("Baking cheese Pizza");
    }

    @Override
    public void cut() {
        logger.info("Cheese Pizza sliced and diced");
    }

    @Override
    public void box() {
        logger.info("Cheese Pizza boxed and ready for pick-up/delivery");
    }
}
