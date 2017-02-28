/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter3_TheDecoratorPattern;

/**
 *
 * @author dean
 */
public class HouseBlend extends Beverage 
{
    public HouseBlend()
    {
        description = "House Blend Coffe";
    }

    @Override
    public double cost() {
        return 0.89;
    }
}
