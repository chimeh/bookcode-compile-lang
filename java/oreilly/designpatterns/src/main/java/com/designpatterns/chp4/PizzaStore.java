package com.designpatterns.chp4;

public abstract class PizzaStore {
    public Pizza order(String type){
        Pizza pizza;

        pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
    abstract Pizza createPizza(String type);
}
