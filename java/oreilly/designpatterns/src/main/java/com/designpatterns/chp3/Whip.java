package com.designpatterns.chp3;

/**
 * Created with IntelliJ IDEA.
 * User: Alan
 * Date: 28/06/14
 * Time: 12:14
 * To change this template use File | Settings | File Templates.
 */
public class Whip extends CondimentDecorator {
    private final Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    @Override
    public double cost() {
        return .10 + beverage.cost();
    }
}
