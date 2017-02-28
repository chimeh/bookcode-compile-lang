package com.designpatterns.chp4;

import org.slf4j.LoggerFactory;

public class NYStyleCheesePizza extends Pizza {

    public NYStyleCheesePizza(){
        logger = LoggerFactory.getLogger(NYStyleCheesePizza.class);
        name="NY style sauce and Cheese Pizza";
        dough="Thin crust dough";
        sauce="Marinara sauce";

        toppings.add("Grated Reggiano Cheese");
    }

}
