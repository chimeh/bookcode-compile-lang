package com.designpatterns.chp4;

/**
 Factory pattern example
 */
public class SimplePizzaFactory {
    public IPizza createPizza(String type){
        IPizza pizza = null;

        if("cheese".equals(type)){
            pizza = new CheeseIPizza();
        }
        if("pepperoni".equals(type)){
            pizza = new PepperoniIPizza();
        }
        if("clam".equals(type)){
            pizza = new ClamIPizza();
        }
        if("veggie".equals(type)){
            pizza = new VeggieIPizza();
        }
        return pizza;
    }
}
