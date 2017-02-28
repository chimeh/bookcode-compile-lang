package com.designpatterns.chp4;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PizzaTestDrive {

    private static Logger logger = LoggerFactory.getLogger(PizzaTestDrive.class);

    public static void main(String [] args){
        PizzaStore nyStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();

        Pizza pizza = nyStore.order("cheese");
        logger.info("Ethan ordered a " + pizza.getName());

        pizza = chicagoStore.order("cheese");
        logger.info("Joel ordered a " + pizza.getName());

    }
}
