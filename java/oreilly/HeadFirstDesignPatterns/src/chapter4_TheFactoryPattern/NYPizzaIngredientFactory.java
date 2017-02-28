/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter4_TheFactoryPattern;

/**
 *
 * @author dean
 */
public class NYPizzaIngredientFactory implements PizzaIngredientFactory
{

    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MariannaSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies veggies[] = { new Garlic(), 
                              new Onion(), 
                              new Mushroom(),
                              new RedPepper() };
        return veggies;
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClams() {
        return new FreshClams();
    }
    
}
