package pizza;

import pizza.additions.AdditionsFactory;

public class CheesePizza extends Pizza {

    AdditionsFactory additionsFactory;

    public CheesePizza(AdditionsFactory additionsFactory) {
        this.additionsFactory = additionsFactory;
    }

    void prepare() {
        System.out.println("Preparing " + name);
        base = additionsFactory.createBase();
        sauce = additionsFactory.createSauce();
        cheese = additionsFactory.createCheese();
    }
}
