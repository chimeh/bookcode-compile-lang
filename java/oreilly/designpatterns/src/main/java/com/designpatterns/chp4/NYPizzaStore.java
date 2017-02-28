package com.designpatterns.chp4;

public class NYPizzaStore extends PizzaStore {
    @Override
    Pizza createPizza(String type) {
        if("cheese".equals(type)){
            return new NYStyleCheesePizza();
        } else if ("pepperoni".equals(type)){
            return new NYStylePepperoniPizza();
        } else if ("clam".equals(type)){
            return new NYStyleClamPizza();
        } else if ("veggie".equals(type)){
            return new NYStyleVeggiePizza();
        } else return null;
    }
}
