/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter4_TheFactoryPattern;

/**
 *
 * @author dean
 */
class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {

    @Override
    public Dough createDough() {
        return new DeepDishDough();
    }

    @Override
    public Sauce createSauce() {
        return new PlumTomattoSauce();
    }

    @Override
    public Cheese createCheese() {
        return new MozarellaAndParmasanCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies veggies[] = { new BlackOlives(), 
                              new Spinach(), 
                              new Eggplant() };
        return veggies;
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClams() {
        return new FrozenClams();
    }
}
