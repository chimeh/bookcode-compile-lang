/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter1_IntroductionToDesignPatterns;

/**
 *
 * @author dean
 */
public class MallardDuck extends Duck
{
    public MallardDuck()
    {
        quackBehaviour = new Quack();
        flyBehaviour = new FlyWithWings();
    }
    
    @Override
    public void display()
    {
        System.out.println("I'm a real Mallard duck");
    }
}
