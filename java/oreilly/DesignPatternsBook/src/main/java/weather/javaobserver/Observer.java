package weather.javaobserver;

import weather.javaobserver.CurrentWeatherData;

public interface Observer {

    void actualize(CurrentWeatherData weatherData);
}
