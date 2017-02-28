package weather.javaobserver;

import java.util.Observable;

public class WeatherController extends Observable{

    private CurrentWeatherData weatherData;

    public WeatherController(){}

    public void changeOfReadings(CurrentWeatherData weatherData){
        setChanged();
        notifyObservers();
    }

    private void readSensors(CurrentWeatherData weatherData) {
        this.weatherData.setHudmity(weatherData.getHudmity());
        this.weatherData.setPressure(weatherData.getPressure());
        this.weatherData.setTemperature(weatherData.getTemperature());
    }

    public int readTemperature() {
        return weatherData.getTemperature();
    }

    public int readPressure() {
        return weatherData.getPressure();
    }

    public int readHudmity() {
        return weatherData.getHudmity();
    }
}
