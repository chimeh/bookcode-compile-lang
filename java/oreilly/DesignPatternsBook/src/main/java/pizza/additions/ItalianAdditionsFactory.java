package pizza.additions;

public class ItalianAdditionsFactory implements AdditionsFactory{

    public Base createBase() {
        return new ThinBase();
    }

    public Sauce createSauce() {
        return new TomatoSauce();
    }

    public Cheese createCheese() {
        return new Parmesan();
    }

    public Vegetable[] createVegetables() {
        Vegetable vegetables[] = {new Garlic(), new Onion(), new Mushrooms(), new RedPepper()};
        return vegetables;
    }

    public Pepperoni createPepperoni() {
        return new ParmienianHam();
    }

    public Chili createChili() {
        return new RedChili();
    }
}
