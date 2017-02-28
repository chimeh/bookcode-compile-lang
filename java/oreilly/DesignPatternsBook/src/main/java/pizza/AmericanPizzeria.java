package pizza;

import pizza.additions.AdditionsFactory;
import pizza.additions.AmericanAdditionsFactory;

public class AmericanPizzeria extends Pizzeria {

    AdditionsFactory additionsFactory;

    protected Pizza createPizza(String type) {

        Pizza pizza = null;
        additionsFactory = new AmericanAdditionsFactory();

        if (type.equals("cheese")) {
            pizza = new CheesePizza(additionsFactory);
            pizza.setName("American cheese pizza");
        } else if (type.equals("vegetarian")) {
            pizza = new VegetarianPizza(additionsFactory);
            pizza.setName("American vegetarian pizza");
        } else if (type.equals("greek")) {
            pizza = new GreekPizza(additionsFactory);
            pizza.setName("American greek pizza");
        } else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza(additionsFactory);
            pizza.setName("American pepperoni pizza");
        }

        return pizza;
    }
}
