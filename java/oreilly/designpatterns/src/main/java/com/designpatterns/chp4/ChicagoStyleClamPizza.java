package com.designpatterns.chp4;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChicagoStyleClamPizza extends Pizza {
    private static final Logger logger = LoggerFactory.getLogger(ChicagoStyleClamPizza.class);

    @Override
    public void prepare() {
        logger.info("Preparing Chicago clam Pizza");
    }

    @Override
    public void bake() {
        logger.info("Baking Chicago clam Pizza");
    }

    @Override
    public void cut() {
        logger.info("Chicago Clam Pizza sliced and diced");
    }

    @Override
    public void box() {
        logger.info("Chicago Clam Pizza boxed and ready for pick-up/delivery");
    }

}
