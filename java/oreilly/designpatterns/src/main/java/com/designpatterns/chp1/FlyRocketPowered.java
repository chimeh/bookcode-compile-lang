package com.designpatterns.chp1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FlyRocketPowered implements FlyBehaviour {

    private final Logger logger = LoggerFactory.getLogger(FlyRocketPowered.class);

    @Override
    public void fly() {
        logger.info("I'm flying with a rocket!");
    }
}
