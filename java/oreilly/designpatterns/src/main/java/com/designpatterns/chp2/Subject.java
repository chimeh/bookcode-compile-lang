package com.designpatterns.chp2;

/**
 * Created with IntelliJ IDEA.
 * User: Alan
 * Date: 24/06/14
 * Time: 22:27
 * To change this template use File | Settings | File Templates.
 */
public interface Subject {

    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
