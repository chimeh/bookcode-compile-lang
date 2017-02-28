package com.designpatterns.chp1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MuteQuack implements QuackBehaviour {
    private static final Logger logger = LoggerFactory.getLogger(MuteQuack.class);

    @Override
    public void quack() {
        logger.info("<< Silence >>");
    }
}
