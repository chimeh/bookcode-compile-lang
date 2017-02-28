package com.designpatterns.chp1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Quack implements QuackBehaviour {

    private static final Logger logger = LoggerFactory.getLogger(Quack.class);

    @Override
    public void quack() {
        logger.info("Quack");
    }
}
