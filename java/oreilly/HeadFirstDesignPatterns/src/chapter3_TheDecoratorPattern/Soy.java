/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter3_TheDecoratorPattern;

/**
 *
 * @author dean
 */
class Soy extends CondimentDecorator 
{
    Beverage beverage;
    
    public Soy(Beverage beverage) 
    {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " , Soy";
    }

    @Override
    public double cost() {
        return 0.15 + beverage.cost();
    }
    
}
