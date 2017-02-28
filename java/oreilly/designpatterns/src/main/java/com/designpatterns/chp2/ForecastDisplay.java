package com.designpatterns.chp2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Alan
 * Date: 24/06/14
 * Time: 23:05
 * To change this template use File | Settings | File Templates.
 */
public class ForecastDisplay implements Observer, DisplayElement{

    private final Logger logger = LoggerFactory.getLogger(ForecastDisplay.class);

    private final Subject weatherData;
    private float temperature;
    private float humidity;
    private float pressure;

    public ForecastDisplay(Subject weatherData) {
        this.weatherData=weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        logger.info("Forecast display: Pressure==" + pressure +", Temp=" + temperature + ", humidity="+humidity);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature=temp;
        this.humidity=humidity;
        this.pressure=pressure;
        display();
    }
}
