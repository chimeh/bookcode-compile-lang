package weather;

public class ActualWeather implements Observer, DisplayElement{

    private Subject weatherController;
    private CurrentWeatherData weatherData;

    public ActualWeather(Subject weatherController) {
        this.weatherController = weatherController;
        weatherController.addObserver(this);
    }

    public void actualize(CurrentWeatherData weatherData) {

        this.weatherData = weatherData;
        display();
    }

    public void display() {
        System.out.println("Actual weather: " + weatherData.toString());
    }
}
