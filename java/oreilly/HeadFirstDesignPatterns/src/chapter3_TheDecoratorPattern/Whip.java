/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter3_TheDecoratorPattern;

/**
 *
 * @author dean
 */
public class Whip extends CondimentDecorator 
{
    Beverage beverage;
    
    public Whip(Beverage beverage)
    {
        this.beverage = beverage;
    }
    
    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    @Override
    public double cost() {
        return 0.10 + beverage.cost();
    }
}
