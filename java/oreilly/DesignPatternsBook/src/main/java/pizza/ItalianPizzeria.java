package pizza;

import pizza.additions.AdditionsFactory;
import pizza.additions.ItalianAdditionsFactory;

public class ItalianPizzeria extends Pizzeria {

    AdditionsFactory additionsFactory;

    protected Pizza createPizza(String type) {

        Pizza pizza = null;
        additionsFactory = new ItalianAdditionsFactory();

        if (type.equals("cheese")) {
            pizza = new CheesePizza(additionsFactory);
            pizza.setName("Italian cheese pizza");
        } else if (type.equals("vegetarian")) {
            pizza = new VegetarianPizza(additionsFactory);
            pizza.setName("Italian vegetarian pizza");
        } else if (type.equals("greek")) {
            pizza = new GreekPizza(additionsFactory);
            pizza.setName("Italian greek pizza");
        } else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza(additionsFactory);
            pizza.setName("Italian pepperoni pizza");
        }

        return pizza;
    }
}
