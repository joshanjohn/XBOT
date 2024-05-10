package clothing;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import model.ForecastDayModel;
import model.WeatherForecastModel;
import weather.WeatherAnalyzer;

public class Recommendation {

	public static String getRecommendation(String cityName) {
		StringBuilder data = new StringBuilder();
		try {
			WeatherAnalyzer analyzer = new WeatherAnalyzer(cityName, 3);

			// gets the weather forecast
			WeatherForecastModel weatherForecastModel = analyzer.getWeatherForecastModel();

			// loop through the forecast for the next 3 days
			for (int i = 0; i < 3; i++) {
				ForecastDayModel forecastDay = weatherForecastModel.getForecastDay(i);
				String date = forecastDay.getDate();
				Double temp = forecastDay.getMostFeelsLikeTemperature();
				String weatherCondition = forecastDay.getWeatherCondition();
				Double wind = forecastDay.getWind();
				if (i == 0) {
					data.append(WeatherSummary.weatherSummary(date, temp, weatherCondition, wind));
				} else {
					data.append("\n\n\n" + WeatherSummary.weatherSummary(date, temp, weatherCondition, wind));
				}
				data.append("\n\n\tRecommendations:-");
				data.append("\n\t" + clothes(temp, weatherCondition, wind));
			}
			return data.toString();
		} catch (Exception e) {
		}
		data.replace(0, data.length(), "No data found. Use '-' for eg:- new-york to get data" );
		return data.toString();
	}

	
	

	// function to convert the date String into the desired format
	protected static String generateDate(String dateString) {

		// parse the input String into a LocalDate object
		LocalDate date = LocalDate.parse(dateString);

		// Format the LocalDate object into the desired format
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
		String formattedDate = date.format(formatter);

		return formattedDate;

	}

	protected static String clothes(Double temp, String weatherCondition, Double wind) {
		// Creating variables
		int windResult = WeatherSummary.analyseWind(wind);
		String recommendation = "";

		// Analysing wind speed
		if (windResult == 4) {
			recommendation += "IT IS STORM! Stay at home!";
			return recommendation;
		}
		// Different results according to temperature
		if (temp > 20)
			recommendation += "Its hot! Wear light clothes, like shorts and t-shirt.";
		else if (temp < 20 && temp >= 15)
			recommendation += "Its warm, not hot. Wear light with light jacket.";
		else if (temp < 15 && temp >= 10)
			recommendation += "Its bit cold. Wear warm, like long-sleeved shirt with sweater & jacket. ";
		else if (temp < 10 && temp >= 0)
			recommendation += "Its cold! Wear warm, like sweater & warm jacket. ";
		else
			recommendation += "Its freezing! Wear really warm. Get gloves, scarf & cap. ";
		// Using also weather condition
		if (weatherCondition.toLowerCase().contains("rainy")
				|| weatherCondition.toLowerCase().contains("rain"))
			recommendation += "\n\tIt is raining, take umbrella!";

		return recommendation;
	}

	
}
