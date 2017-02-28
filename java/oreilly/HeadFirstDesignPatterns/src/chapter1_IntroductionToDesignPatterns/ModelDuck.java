/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter1_IntroductionToDesignPatterns;

/**
 *
 * @author dean
 */
public class ModelDuck extends Duck
{

    @Override
    public void display()
    {
        System.out.println("I'm a model duck");
    }
    
    public ModelDuck()
    {
        flyBehaviour = new FlyNoWay();
        quackBehaviour = new Quack();
    }
    
}
