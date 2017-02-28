package com.designpatterns.chp3;

/**
 Beverage supertype
 */
public abstract class Beverage {
    String description ="Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
