package com.designpatterns.chp1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FlyWithWings implements FlyBehaviour {

    private final static Logger logger = LoggerFactory.getLogger(FlyWithWings.class);

    @Override
    public void fly() {
        logger.info("I'm flying");
    }
}
