/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter1_IntroductionToDesignPatterns;

/**
 *
 * @author dean
 */
public class MiniDuckSimulator
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Duck mallard = new MallardDuck();
        
        mallard.performQuack();
        mallard.performFly();
        
        Duck model = new ModelDuck();
        
        model.performFly();
        model.setFlyBehaviour(new FlyRocketPowered());
        model.performFly();
    }
}
