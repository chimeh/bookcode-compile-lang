/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter1_IntroductionToDesignPatterns;

/**
 *
 * @author dean
 */
public class Quack implements QuackBehaviour
{

    @Override
    public void quack()
    {
        System.out.println("Quack!");
    }
    
}
