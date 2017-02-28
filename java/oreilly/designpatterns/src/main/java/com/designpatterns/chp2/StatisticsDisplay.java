package com.designpatterns.chp2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Alan
 * Date: 24/06/14
 * Time: 22:59
 * To change this template use File | Settings | File Templates.
 */
public class StatisticsDisplay implements Observer, DisplayElement{

    private final Logger logger = LoggerFactory.getLogger(StatisticsDisplay.class);

    private final Subject weatherData;
    private float temperature;
    private float humidity;
    private float pressure;

    public StatisticsDisplay(Subject weatherData) {
        this.weatherData=weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
            logger.info("Stat display: temp="+temperature + ", humidity="+humidity + ", pressure="+pressure);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature=temperature;
        this.humidity=humidity;
        this.pressure=pressure;
        display();
    }
}
