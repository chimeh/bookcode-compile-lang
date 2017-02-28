package com.designpatterns.chp4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChicagoStylePepperoniPizza extends Pizza {

    private static final Logger logger = LoggerFactory.getLogger(ChicagoStylePepperoniPizza.class);

    @Override
    public void prepare() {
        logger.info("Preparing Chicago pepperoni Pizza");
    }

    @Override
    public void bake() {
        logger.info("Baking Chicago pepperoni Pizza");
    }

    @Override
    public void cut() {
        logger.info("Chicago Pepperoni Pizza sliced and diced");
    }

    @Override
    public void box() {
        logger.info("Chicago Pepperoni Pizza boxed and ready for pick-up/delivery");
    }
}
