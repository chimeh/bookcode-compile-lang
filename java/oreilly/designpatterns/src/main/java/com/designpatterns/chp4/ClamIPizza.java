package com.designpatterns.chp4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClamIPizza extends Pizza {
    private static final Logger logger = LoggerFactory.getLogger(ClamIPizza.class);

    @Override
    public void prepare() {
        logger.info("Preparing clam Pizza");
    }

    @Override
    public void bake() {
        logger.info("Baking clam Pizza");
    }

    @Override
    public void cut() {
        logger.info("Clam Pizza sliced and diced");
    }

    @Override
    public void box() {
        logger.info("Clam Pizza boxed and ready for pick-up/delivery");
    }
}
