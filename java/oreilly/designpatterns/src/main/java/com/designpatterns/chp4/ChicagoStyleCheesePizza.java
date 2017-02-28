package com.designpatterns.chp4;

import org.slf4j.LoggerFactory;

public class ChicagoStyleCheesePizza extends Pizza {

    public ChicagoStyleCheesePizza() {
        logger = LoggerFactory.getLogger(ChicagoStyleCheesePizza.class);
        name="Chicago Style Deep Dish Cheese Pizza";
        dough="Extra Thick Crust Dough";
        sauce="Plum Tomato Sauce";

        toppings.add("Shredded Mozzarella Cheese");
    }

    @Override
    public void cut(){
        logger.info("Cutting the pizza into square slices");
    }
}
