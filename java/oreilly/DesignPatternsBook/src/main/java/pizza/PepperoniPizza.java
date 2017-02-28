package pizza;

import pizza.additions.AdditionsFactory;

public class PepperoniPizza extends Pizza {

    AdditionsFactory additionsFactory;

    public PepperoniPizza(AdditionsFactory additionsFactory) {
        this.additionsFactory = additionsFactory;
    }

    void prepare() {
        System.out.println("Preapring: " + name);
        base = additionsFactory.createBase();
        sauce = additionsFactory.createSauce();
        cheese = additionsFactory.createCheese();
        pepperoni = additionsFactory.createPepperoni();
    }
}
