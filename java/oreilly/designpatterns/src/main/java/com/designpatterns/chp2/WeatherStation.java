package com.designpatterns.chp2;

/**
 * Created with IntelliJ IDEA.
 * User: Alan
 * Date: 24/06/14
 * Time: 22:52
 * To change this template use File | Settings | File Templates.
 */
public class WeatherStation{
    public static void main(String [] args){
        WeatherData weatherData = new WeatherData();

        CurrentConditionDisplay currentDisplay = new CurrentConditionDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

        weatherData.setMeasurements(80,65,30.4f);
        weatherData.setMeasurements(70,50,40.2f);
    }
}
