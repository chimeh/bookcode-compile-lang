package com.designpatterns.chp2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Alan
 * Date: 24/06/14
 * Time: 22:39
 * To change this template use File | Settings | File Templates.
 */
public class CurrentConditionDisplay implements Observer, DisplayElement {

    private final Logger logger = LoggerFactory.getLogger(CurrentConditionDisplay.class);

    private final Subject weatherData;
    private float temperature;
    private float humidity;
    private float pressure;

    public CurrentConditionDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        logger.info("Current conditions: " + temperature + "F degrees, " + humidity + "% humidity" +" and pressure:"+pressure);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature=temperature;
        this.humidity=humidity;
        this.pressure=pressure;
        display();
    }
}
