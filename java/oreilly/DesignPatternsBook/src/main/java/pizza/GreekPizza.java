package pizza;

import pizza.additions.AdditionsFactory;

public class GreekPizza extends Pizza{

    AdditionsFactory additionsFactory;

    public GreekPizza(AdditionsFactory additionsFactory) {
        this.additionsFactory = additionsFactory;
    }

    void prepare() {
        System.out.println("Preapring: " + name);
        base = additionsFactory.createBase();
        sauce = additionsFactory.createSauce();
        cheese = additionsFactory.createCheese();
        vegetables = additionsFactory.createVegetables();
        pepperoni = additionsFactory.createPepperoni();
    }
}
