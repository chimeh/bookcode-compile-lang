package com.designpatterns.chp1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Subtract implements Strategy {

    private final Logger logger = LoggerFactory.getLogger(Subtract.class);

    @Override
    public int execute(int a, int b) {
        logger.info("Called Subtract's execute()");
        return a-b;
    }
}
