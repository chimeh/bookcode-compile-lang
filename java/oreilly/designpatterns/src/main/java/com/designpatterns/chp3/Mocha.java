package com.designpatterns.chp3;

/**
Mocha condiment implementation
 */
public class Mocha extends CondimentDecorator {
    private final Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage=beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public double cost() {
        return .20 + beverage.cost();
    }
}
