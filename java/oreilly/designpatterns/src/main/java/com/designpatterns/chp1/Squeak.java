package com.designpatterns.chp1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Squeak implements QuackBehaviour {

    private static final Logger logger = LoggerFactory.getLogger(Squeak.class);

    @Override
    public void quack() {
        logger.info("Squeak");
    }
}
