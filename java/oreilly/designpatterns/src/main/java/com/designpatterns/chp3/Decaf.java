package com.designpatterns.chp3;

/**
 Decaf implementation
 */
public class Decaf extends Beverage {

    public Decaf() {
        description = "Decaf";
    }

    @Override
    public double cost() {
        return 1.05;
    }
}
