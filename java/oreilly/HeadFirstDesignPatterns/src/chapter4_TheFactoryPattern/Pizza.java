/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter4_TheFactoryPattern;

import java.util.ArrayList;

/**
 *
 * @author dean
 */
public abstract class Pizza {
    String name;
    Dough dough;
    Sauce sauce;
    Veggies veggies[];
    Cheese cheese;
    Pepperoni pepperoni;
    Clams clams;
    
    abstract void prepare();

    void bake()
    {
        System.out.println("Bake for 25 minutes at 350F");
    }

    void cut()
    {
        System.out.println("Cutting pizza into slices");
    }

    void box()
    {
        System.out.println("Place pizza in official PizzaStore box");
    }
    
    public String getName()
    {
        return name;
    }
    
    @Override
    public String toString()
    {
        return "";
    }

    void setName(String name) 
    {
        this.name = name;
    }
}
