package com.designpatterns.chp2;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Alan
 * Date: 24/06/14
 * Time: 22:32
 * To change this template use File | Settings | File Templates.
 */
public class WeatherData implements Subject {
    private final ArrayList<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        observers = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(int i=0; i<observers.size(); i++ ){
            Observer observer = (Observer)observers.get(i);
            observer.update(temperature, humidity, pressure);
        }
    }

    public void setMeasurements(float temperature, float humidity, float pressure){
        this.temperature=temperature;
        this.humidity=humidity;
        this.pressure=pressure;
        measurementsChanged();
    }

    private void measurementsChanged() {
        notifyObservers();
    }
}
