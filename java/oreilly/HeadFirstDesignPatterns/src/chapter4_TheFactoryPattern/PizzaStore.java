/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter4_TheFactoryPattern;

/**
 *
 * @author dean
 */
public abstract class PizzaStore 
{
    //SimplePizzaFactory factory;
    
    //public PizzaStore(SimplePizzaFactory factory)
    //{
    //    this.factory = factory;
    //}
    
    public Pizza orderPizza(String type)
    {
        Pizza pizza;
        
        pizza = createPizza(type);
        
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
    
    abstract Pizza createPizza(String type);
}
