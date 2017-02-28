package com.designpatterns.chp1;


import org.slf4j.LoggerFactory;

public class Multiply implements Strategy {
    private org.slf4j.Logger logger = LoggerFactory.getLogger(Multiply.class);

    @Override
    public int execute(int a, int b) {
        logger.info("Called Multiply's execute()");
        return a*b;
    }
}
