package com.designpatterns.chp3;

/**
 Dark Roast Implementation.
 */
public class DarkRoast extends Beverage {

    public DarkRoast() {
        description="Dark Roast";
    }

    @Override
    public double cost() {
        return .99;
    }
}
