package weather;

import model.WeatherForecastModel;

/*
 * Use of this class is :
 * this class will help to convert the weather data into model objects (WeatherForecastModel)
 */

public class WeatherAnalyzer {
	private final WeatherApiConnection weatherApiConnection;

	// Constructor to initialize WeatherAnalyzer with a WeatherApiConnection
	// instance
	public WeatherAnalyzer(String cityName, int days) {
		this.weatherApiConnection = new WeatherApiConnection(cityName, days);
	}

	public WeatherForecastModel getWeatherForecastModel() throws Exception {
		/*
		 * Method to return the weather forecast model
		 */
		// Get weather data from the API connection
		String weatherData = weatherApiConnection.getWeatherData();
		// Create a new WeatherForecastModel instance using the retrieved weather data
		return new WeatherForecastModel(weatherData);
	}
}
