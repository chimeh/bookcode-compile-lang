package com.designpatterns.chp4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VeggieIPizza implements IPizza {
    private static final Logger logger = LoggerFactory.getLogger(VeggieIPizza.class);

    @Override
    public void prepare() {
        logger.info("Preparing veggie Pizza");
    }

    @Override
    public void bake() {
        logger.info("Baking veggie Pizza");
    }

    @Override
    public void cut() {
        logger.info("Veggie Pizza sliced and diced");
    }

    @Override
    public void box() {
        logger.info("Veggie Pizza boxed and ready for pick-up/delivery");
    }
}
