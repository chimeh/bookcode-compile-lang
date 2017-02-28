/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter3_TheDecoratorPattern;

/**
 *
 * @author dean
 */
public class DarkRoast extends Beverage 
{
    public DarkRoast()
    {
        description = "Dark Roast";
    }
    
    @Override
    public double cost()
    {
        return 0.99;
    }
}
