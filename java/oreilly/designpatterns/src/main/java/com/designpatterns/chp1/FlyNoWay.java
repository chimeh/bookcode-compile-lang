package com.designpatterns.chp1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FlyNoWay implements FlyBehaviour {

    private final static Logger logger = LoggerFactory.getLogger(FlyNoWay.class);

    @Override
    public void fly() {
        logger.info("I can't fly");
    }
}
