package pizza.additions;

public class AmericanAdditionsFactory implements AdditionsFactory {

    public Base createBase() {
        return new ThickBase();
    }

    public Sauce createSauce() {
        return new BBQSauce();
    }

    public Cheese createCheese() {
        return new Mozzarella();
    }

    public Vegetable[] createVegetables() {
        Vegetable vegetables[] = {new Onion(), new Corn(), new BlackOlives()};
        return vegetables;
    }

    public Pepperoni createPepperoni() {
        return new Salami();
    }

    public Chili createChili() {
        return new Jalapeno();
    }
}
