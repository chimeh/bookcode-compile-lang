package weather;

public class Main {

    public static void main(String[] args) {

        WeatherController controller = new WeatherController();

        ActualWeather actualWeather = new ActualWeather(controller);
        Prognose prognose = new Prognose(controller);
        Statistics statistics = new Statistics(controller);
        HeatIndex heatIndex = new HeatIndex(controller);

        CurrentWeatherData currentWeatherData = new CurrentWeatherData(10,1015,30);
        controller.changeOfReadings(currentWeatherData);

    }
}
