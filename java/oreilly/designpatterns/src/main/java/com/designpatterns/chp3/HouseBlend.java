package com.designpatterns.chp3;

/**
 House Blend implementation
 */
public class HouseBlend extends Beverage {
    public HouseBlend() {
        description = "House Blend";
    }

    @Override
    public double cost() {
        return .89;
    }
}
