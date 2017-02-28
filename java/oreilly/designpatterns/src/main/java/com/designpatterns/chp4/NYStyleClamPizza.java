package com.designpatterns.chp4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NYStyleClamPizza extends Pizza {
    private static final Logger logger = LoggerFactory.getLogger(NYStyleClamPizza.class);

    @Override
    public void prepare() {
        logger.info("Preparing NY clam Pizza");
    }

    @Override
    public void bake() {
        logger.info("Baking NY clam Pizza");
    }

    @Override
    public void cut() {
        logger.info("NY Clam Pizza sliced and diced");
    }

    @Override
    public void box() {
        logger.info("NY Clam Pizza boxed and ready for pick-up/delivery");
    }
}
