package weather.javaobserver;

import weather.CurrentWeatherData;
import weather.DisplayElement;
import weather.Subject;

import java.util.Observable;

public class ActualWeather implements java.util.Observer, DisplayElement{

    Observable observable;
    private int temperature;
    private int hudmity;

    public ActualWeather(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    public void display() {
        System.out.println("Actual weather: Tempearute = " +
                this.temperature + "; hudmity = " +  this.hudmity + ".");
    }

    public void update(Observable o, Object arg) {
        if(o instanceof WeatherController){
            WeatherController weatherController = (WeatherController) o;
            this.temperature = weatherController.readTemperature();
            this.hudmity = weatherController.readHudmity();
            display();
        }
    }
}
