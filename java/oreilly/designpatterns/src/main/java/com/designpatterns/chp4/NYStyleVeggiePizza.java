package com.designpatterns.chp4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NYStyleVeggiePizza extends Pizza {
    private static final Logger logger = LoggerFactory.getLogger(NYStyleVeggiePizza.class);

    @Override
    public void prepare() {
        logger.info("Preparing NY veggie Pizza");
    }

    @Override
    public void bake() {
        logger.info("Baking NY veggie Pizza");
    }

    @Override
    public void cut() {
        logger.info("NY Veggie Pizza sliced and diced");
    }

    @Override
    public void box() {
        logger.info("NY Veggie Pizza boxed and ready for pick-up/delivery");
    }
}
