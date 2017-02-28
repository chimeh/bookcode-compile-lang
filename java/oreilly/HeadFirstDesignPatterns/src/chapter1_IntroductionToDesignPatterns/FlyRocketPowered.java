/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter1_IntroductionToDesignPatterns;

/**
 *
 * @author dean
 */
public class FlyRocketPowered implements FlyBehaviour
{

    @Override
    public void fly()
    {
        System.out.println("I'm flying with a rocket!");
    }
    
}
