package com.designpatterns.chp1;

/**
 * Configured with a ConcreteStrategy object and maintains
 * a reference to a Strategy object
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int a, int b){
        return this.strategy.execute(a,b);
    }
}
