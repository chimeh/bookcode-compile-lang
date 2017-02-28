package weather;

public class Prognose implements Observer, DisplayElement {

    private Subject weatherController;
    private CurrentWeatherData weatherData;

    public Prognose(Subject weatherController) {
        this.weatherController = weatherController;
        weatherController.addObserver(this);
    }

    public void actualize(CurrentWeatherData weatherData) {
        this.weatherData = weatherData;
        display();
    }

    public void display() {
        System.out.println("Prognose: " + weatherData.toString());
    }
}
