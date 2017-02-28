package com.designpatterns.chp3;

/**
 Soya condiment
 */
public class Soy extends CondimentDecorator {
    private final Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage=beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", soya";
    }

    @Override
    public double cost() {
        return .15 + beverage.cost();
    }
}
