package com.designpatterns.chp1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implements the algorithm using the strategy interface
 */
public class Add implements Strategy {

    Logger logger = LoggerFactory.getLogger(Add.class);

    @Override
    public int execute(int a, int b) {
        logger.info("Called Add's execute()");
        return a+b;
    }
}
