/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter4_TheFactoryPattern;

/**
 *
 * @author dean
 */
class ClamPizza extends Pizza {
    PizzaIngredientFactory ingredientFactory;
    
    public ClamPizza(PizzaIngredientFactory ingredientFactory) 
    {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    void prepare()
    {
        System.err.println("Preparing " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
        clams = ingredientFactory.createClams();
    }
}
