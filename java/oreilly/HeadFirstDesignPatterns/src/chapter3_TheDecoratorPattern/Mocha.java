/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter3_TheDecoratorPattern;

/**
 *
 * @author dean
 */
public class Mocha extends CondimentDecorator 
{
    Beverage beverage;
    
    public Mocha(Beverage beverage)
    {
        this.beverage = beverage;
    }
    
    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public double cost() {
        return 0.20 + beverage.cost();
    }
    
}
