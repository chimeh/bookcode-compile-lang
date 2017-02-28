/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter1_IntroductionToDesignPatterns;

/**
 *
 * @author dean
 */
public class MuteQuack implements QuackBehaviour
{

    @Override
    public void quack()
    {
        System.out.println("<<< Silence >>>");
    }
    
}
