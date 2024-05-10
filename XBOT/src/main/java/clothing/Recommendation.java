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
		int tempResult = WeatherSummary.temp(temp);
		boolean rainResult = WeatherSummary.isRaining(weatherCondition);
		boolean sunResult = WeatherSummary.isSunny(weatherCondition);
		boolean snowResult = WeatherSummary.isSnowy(weatherCondition);
		String recommendation = "";

		// Analysing wind speed
		if (windResult == 4) {
			recommendation += "IT IS STORM! I highly recommend you to stay at home.";
			return recommendation;
		}
		// Different results according to weather conditions

		// Temperature cases
		switch (tempResult) {
			case 1:
				recommendation += "It's a hot day! Wear something light like shorts and t-shirt. ";
				break;
			case 2:
				recommendation += "It's warm, not hot. I recommend to wear something light but with jacket. ";
				break;
			case 3:
				recommendation += "It's a bit cold. Wear something warm, like long-sleeved shirt with sweater & jacket. ";
				break;
			case 4:
				recommendation += "It's cold! Wear something warm, like sweater & warm jacket. ";
				break;
			case 5:
				recommendation += "Its freezing! Wear really warm. Get gloves, scarf & cap. ";
				break;
		}

		// Wind case
		if (windResult == 3)
			recommendation += "Also, due to wind it may feel a little bit cooler";

		// Rain case
		if (rainResult)
			recommendation += "Don't forget about umbrella!";

		// Sun case
		if (sunResult && (tempResult == 1 || tempResult == 2))
			recommendation += "I also recommend you to take the cap.";

		// Snow case
		if (snowResult)
			recommendation += "EXTRA RECOMENDATION :) It s snowing, so try to build a snowman!!";
		return recommendation;

	}

}
