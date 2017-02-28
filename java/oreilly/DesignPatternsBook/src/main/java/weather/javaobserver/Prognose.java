package weather.javaobserver;

import weather.DisplayElement;

import java.util.Observable;
import java.util.Observer;

public class Prognose implements Observer, DisplayElement{

    private int currentPressure = 1000;
    private int lastPressure;

    public Prognose(Observable observable){
        observable.addObserver(this);
    }

    public void update(Observable observable, Object arg) {
        if(observable instanceof WeatherController){
            WeatherController weatherController = (WeatherController) observable;
            lastPressure = currentPressure;
            currentPressure = weatherController.readPressure();
            display();
        }
    }

    public void display() {
        if(currentPressure > lastPressure){
            System.out.println("Tomorrow will be sunny");
        } else if (currentPressure == lastPressure){
            System.out.println("Tomorrow waether will not change");
        } else{
            System.out.println("Tomorrow will be rainy");
        }
    }
}
