package pizza;

import pizza.additions.AdditionsFactory;

public class SeashellPizza extends Pizza {

    AdditionsFactory additionsFactory;

    public SeashellPizza(AdditionsFactory additionsFactory) {
        this.additionsFactory = additionsFactory;
    }

    void prepare() {
        System.out.println("Preapring: " + name);
        base = additionsFactory.createBase();
        sauce = additionsFactory.createSauce();
        cheese = additionsFactory.createCheese();
        vegetables = additionsFactory.createVegetables();
        pepperoni = additionsFactory.createPepperoni();
        chili = additionsFactory.createChili();
    }
}
