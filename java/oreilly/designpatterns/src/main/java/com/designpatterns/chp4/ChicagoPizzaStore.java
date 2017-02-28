package com.designpatterns.chp4;

public class ChicagoPizzaStore extends PizzaStore {
    @Override
    Pizza createPizza(String type) {
        if("cheese".equals(type)){
            return new ChicagoStyleCheesePizza();
        } else if ("pepperoni".equals(type)){
            return new ChicagoStylePepperoniPizza();
        } else if ("clam".equals(type)){
            return new ChicagoStyleClamPizza();
        } else if ("veggie".equals(type)){
            return new ChicagoStyleVeggieIPizza();
        } else return null;
    }
}
