/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter3_TheDecoratorPattern;

/**
 *
 * @author dean
 */
public class Espresso extends Beverage
{
    public Espresso()
    {
        description = "Espresso";
    }
    
    @Override
    public double cost() {
        return 1.99;
    }
    
}
