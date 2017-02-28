package weather;

public class Statistics implements Observer, DisplayElement{

    private Subject weatherController;
    private CurrentWeatherData weatherData;

    public Statistics(Subject weatherController) {
        this.weatherController = weatherController;
        weatherController.addObserver(this);
    }

    public void actualize(CurrentWeatherData weatherData) {
        this.weatherData = weatherData;
        display();
    }

    public void display() {
        System.out.println("Statitics:" + weatherData.toString());
    }
}
