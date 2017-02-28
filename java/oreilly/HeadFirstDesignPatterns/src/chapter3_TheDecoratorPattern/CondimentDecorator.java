/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter3_TheDecoratorPattern;

/**
 *
 * @author dean
 */
public abstract class CondimentDecorator extends Beverage 
{
    @Override
    public abstract String getDescription();
}
