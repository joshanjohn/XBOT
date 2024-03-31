package weather;

public class WeatherAnalyzer {
	private final WeatherApiConnection weatherApiConnection;

	// Constructor to initialize WeatherAnalyzer with a WeatherApiConnection
	// instance
	public WeatherAnalyzer(String cityName, int days) {
		this.weatherApiConnection = new WeatherApiConnection(cityName, days);
	}

}
