package weather.javaobserver;

public class CurrentWeatherData {

    private int temperature;
    private int pressure;
    private int hudmity;

    public CurrentWeatherData(){}

    public CurrentWeatherData(int temperature, int pressure, int hudmity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.hudmity = hudmity;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHudmity() {
        return hudmity;
    }

    public void setHudmity(int hudmity) {
        this.hudmity = hudmity;
    }

    @Override
    public String toString() {
        return "CurrentWeatherData{" +
                "temperature=" + temperature +
                ", pressure=" + pressure +
                ", hudmity=" + hudmity +
                '}';
    }
}
