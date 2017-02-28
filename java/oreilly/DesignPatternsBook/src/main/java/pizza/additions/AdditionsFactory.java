package pizza.additions;

public interface AdditionsFactory {

    Base createBase();
    Sauce createSauce();
    Cheese createCheese();
    Vegetable[] createVegetables();
    Pepperoni createPepperoni();
    Chili createChili();
}
