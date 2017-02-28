package com.designpatterns.chp3;

import org.slf4j.LoggerFactory;

/**
Test class for calculating cost of beverages and their assigned condiments.
 */
public class StarbuzzCoffee {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(StarbuzzCoffee.class);

    public static void main(String [] args){
        Beverage beverage = new Espresso();
        logger.info(beverage.getDescription() + " $" + beverage.cost());

        Beverage beverage2 = new DarkRoast();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        logger.info(beverage2.getDescription() + " $" + beverage2.cost());

        Beverage beverage3 = new HouseBlend();
        beverage3 = new Soy(beverage3);
        beverage3 = new Mocha(beverage3);
        beverage3 = new Whip(beverage3);
        logger.info(beverage3.getDescription() + " $" + beverage3.cost());
    }
}
