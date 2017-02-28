package weather;

import java.util.ArrayList;
import java.util.List;

public class WeatherController implements Subject{

    private List<Observer> observers;
    private CurrentWeatherData weatherData;

    public WeatherController(){
        observers = new ArrayList<Observer>();
        weatherData = new CurrentWeatherData();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void sendData() {
        for(Observer observer:observers){
            observer.actualize(weatherData);
        }
    }

    public void changeOfReadings(CurrentWeatherData weatherData){
        readSensors(weatherData);
        sendData();
    }

    private void readSensors(CurrentWeatherData weatherData) {
        this.weatherData.setHudmity(weatherData.getHudmity());
        this.weatherData.setPressure(weatherData.getPressure());
        this.weatherData.setTemperature(weatherData.getTemperature());
    }

    private int readTemperature() {
        return weatherData.getTemperature();
    }

    private int readPressure() {
        return weatherData.getPressure();
    }

    private int readHudmity() {
        return weatherData.getPressure();
    }
}
