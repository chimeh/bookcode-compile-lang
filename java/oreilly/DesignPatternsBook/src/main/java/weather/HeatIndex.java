package weather;

public class HeatIndex implements Observer, DisplayElement{

    private Subject weatherController;
    private CurrentWeatherData weatherData;
    private float heatIndex;

    public HeatIndex(Subject weatherController) {
        this.weatherController = weatherController;
        weatherController.addObserver(this);
    }

    public void actualize(CurrentWeatherData weatherData) {
        this.weatherData = weatherData;
        display();
    }

    public void display() {
        calculateIndex();
        System.out.println("Heat index = " + heatIndex);
    }

    private void calculateIndex(){
        heatIndex = (float)((16.923 + (0.185212 * weatherData.getTemperature()) +
                (5.37941 * weatherData.getHudmity()) -
                (0.100254 * weatherData.getTemperature() * weatherData.getHudmity()) +
                (0.00941695 * (weatherData.getTemperature() * weatherData.getTemperature())) +
                (0.00728898 * (weatherData.getHudmity() * weatherData.getHudmity())) +
                (0.000345372 * (weatherData.getTemperature() * weatherData.getTemperature() * weatherData.getHudmity())) -
                (0.000814971 * (weatherData.getTemperature() * weatherData.getHudmity() * weatherData.getHudmity())) +
                (0.0000102102 * (weatherData.getTemperature() * weatherData.getTemperature() * weatherData.getHudmity() * weatherData.getHudmity())) -
                (0.000038646 * (weatherData.getTemperature() * weatherData.getTemperature() * weatherData.getTemperature())) +
                (0.0000291583 * (weatherData.getHudmity() * weatherData.getHudmity() * weatherData.getHudmity())) + (0.00000142721 *
                (weatherData.getTemperature() * weatherData.getTemperature() * weatherData.getTemperature() * weatherData.getHudmity())) +
                (0.000000197483 * (weatherData.getTemperature() * weatherData.getHudmity() * weatherData.getHudmity() * weatherData.getHudmity())) -
                (0.0000000218429 * (weatherData.getTemperature() * weatherData.getTemperature() * weatherData.getTemperature() * weatherData.getHudmity() * weatherData.getHudmity())) +
                0.000000000843296 * (weatherData.getTemperature() * weatherData.getTemperature() * weatherData.getHudmity() * weatherData.getHudmity() * weatherData.getHudmity())) -
                (0.0000000000481975 * (weatherData.getTemperature() * weatherData.getTemperature() * weatherData.getTemperature() * weatherData.getHudmity() * weatherData.getHudmity() * weatherData.getHudmity())));

    }
}
