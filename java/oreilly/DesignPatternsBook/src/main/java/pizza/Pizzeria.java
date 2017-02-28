package pizza;

public abstract class Pizzeria {

    public Pizza orderPizza(String type) {

        Pizza pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.pack();

        return pizza;
    }

    abstract Pizza createPizza(String type);
}
