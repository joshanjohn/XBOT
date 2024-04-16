package clothing;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import model.ForecastDayModel;
import model.WeatherForecastModel;
import weather.WeatherAnalyzer;

public class Recommendation {

	// public static String getRecommendation(String cityName) {
	// StringBuilder data = new StringBuilder();
	// try {
	// WeatherAnalyzer analyser = new WeatherAnalyzer(cityName, 3);
	//
	// //gets the weather forecast
	// WeatherForecastModel weatherForecastModel =
	// analyzer.getWeatherForecastModel();
	//
	// //loop through the forecast for the next 3 days
	// for(int i = 0; i < 3; i++) {
	// ForecastDayModel forecastDay = weatherForecastModel.getForecastDay(i);
	// String date = forecastDay.getDate();
	// Double temp = forecastDay.getMostFeelsLikeTemperature();
	// String weatherCondition = forecastDay.getWeatherCondition();
	// Double wind = forecast.getWind();
	// if (i==0) {
	// data.append(weatherSummary(date,date, weatherCondition,wind));
	// }else {
	// data.append("\n\n\n" + weatherSummary(date,date, weatherCondition,wind));
	// }
	// data.append("\n\n\tRecommendations for this day"));
	// data.append("\n\t" + clothes(temp,weatherCondition));
	// }return null;
	// }catch(Exception e) {
	// }
	// data.replace(0, data.length(),"No data found"));
	// return null;
	// }

	/**
	 * Generates a weather summary based on provided parameters.
	 *
	 * @param date      The date for which the weather summary is generated.
	 * @param temp      The temperature for the given date.
	 * @param condition The weather condition for the given date.
	 * @param wind      The wind speed for the given date.
	 * @return A formatted weather summary string.
	 */
	protected static String weatherSummary(String date, String temp, String condition, Double wind) {
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
