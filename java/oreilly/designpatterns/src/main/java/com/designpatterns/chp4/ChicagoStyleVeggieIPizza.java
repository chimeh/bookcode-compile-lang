package com.designpatterns.chp4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChicagoStyleVeggieIPizza  extends Pizza {

    private static final Logger logger = LoggerFactory.getLogger(ChicagoStyleVeggieIPizza.class);

    @Override
    public void prepare() {
        logger.info("Preparing Chicago veggie Pizza");
    }

    @Override
    public void bake() {
        logger.info("Baking Chicago veggie Pizza");
    }

    @Override
    public void cut() {
        logger.info("Chicago Veggie Pizza sliced and diced");
    }

    @Override
    public void box() {
        logger.info("Chicago Veggie Pizza boxed and ready for pick-up/delivery");
    }
}
