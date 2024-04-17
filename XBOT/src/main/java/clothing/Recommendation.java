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
					data.append(weatherSummary(date, temp, weatherCondition, wind));
				} else {
					data.append("\n\n\n" + weatherSummary(date, temp, weatherCondition, wind));
				}
				data.append("\n\n\tRecommendations for this day");
				data.append("\n\t" + clothes(temp, weatherCondition, wind));
			}
			return data.toString();
		} catch (Exception e) {
		}
		data.replace(0, data.length(), "No data found");
		return data.toString();
	}

	/**
	 * Generates a weather summary based on provided parameters.
	 *
	 * @param date      The date for which the weather summary is generated.
	 * @param temp      The temperature for the given date.
	 * @param condition The weather condition for the given date.
	 * @param wind      The wind speed for the given date.
	 * @return A formatted weather summary string.
	 */
	protected static String weatherSummary(String date, Double temp, String condition, Double wind) {
		return "\n\t> On " + generateDate(date) + ", the weather with most feel like \n\ttemperature of " + temp
				+ "°C, \n\taccompanied by " + condition + " weather conditions and \n\ta wind speed of " + wind
				+ "km/h.";
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
		int windResult = analyseWind(wind);
		String recommendation = "";

		// Analysing wind speed
		if (windResult == 4) {
			recommendation += "IT IS STORM! Stay at home!";
			return recommendation;
		}
		// Different results according to temperature
		if (temp > 20)
			recommendation += "It is hot! Wear something light, like shorts and t-shirt. Don't forget about headdress. ";
		else if (temp < 20 && temp >= 15)
			recommendation += "It is warm, but not hot. Wear something light but take the jacket.";
		else if (temp < 15 && temp >= 10)
			recommendation += "It is a little bit cold. Wear something light that warms you, \n\tlike a long-sleeved shirt with a sweater or fleece, topped with a jacket. ";
		else if (temp < 10 && temp >= 0)
			recommendation += "It is cold! Wear something warm, like sweater, topped with warm jacket and jeans. ";
		else
			recommendation += "It is freezing! Wear something really warm. Don't forget about the gloves, a scarf and a cap. ";
		// Using also weather condition
		if (weatherCondition.toLowerCase().contains("rainy")
				|| weatherCondition.toLowerCase().contains("rain"))
			recommendation += "\n\tIt is also rainy, so don't forget about umbrella!";

		return recommendation;
	}

	protected static int analyseWind(Double wind) {
		// method that returns wind description according to its speed

		/*
		 * method that returns wind description according to its speed
		 * groups:
		 * 1 means the light wind
		 * 2 means the moderate wind
		 * 3 means strong wind
		 * 4 means very strong wind
		 */

		if (wind <= 1 && wind >= 0)
			return 1;
		else if (wind <= 5 && wind > 1)
			return 1;
		else if (wind <= 11 && wind > 5)
			return 1;
		else if (wind <= 19 && wind > 11)
			return 1;
		else if (wind <= 29 && wind > 19)
			return 2;
		else if (wind <= 39 && wind > 29)
			return 2;
		else if (wind <= 49 && wind > 39)
			return 2;
		else if (wind <= 61 && wind > 49)
			return 2;
		else if (wind <= 74 && wind > 61)
			return 3;
		else if (wind <= 88 && wind > 74)
			return 3;
		else if (wind <= 102 && wind > 88)
			return 4;
		else if (wind <= 117 && wind > 102)
			return 4;
		else if (wind <= 134 && wind > 117)
			return 4;
		return 0;
	}

}
