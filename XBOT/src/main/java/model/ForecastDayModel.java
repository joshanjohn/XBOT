package model;

import org.json.JSONArray;
import org.json.JSONObject;

public class ForecastDayModel {
	private final JSONObject forecastDayJson;

	// Constructor to initialize the ForecastDayModel with forecast day JSON data
	public ForecastDayModel(JSONObject forecastDayJson) {
		this.forecastDayJson = forecastDayJson;
	}

	public String getDate() {
		/*
		 * method to return the date from the JSON object in forecastDayJson
		 */
		if (forecastDayJson.isNull("date")) {
			return null;
		}
		return forecastDayJson.getString("date");
	}

	public double getWind(String string) {
		/*
		 * method to return the wind speed in kph.
		 */
		return forecastDayJson.getJSONObject("day").getDouble("maxwind_kph");
	}

	public double getMostFeelsLikeTemperature() {
		/*
		 * method to return the most feels like temperature in celcius.
		 */

		// getting JSON for hours from the forecastDayJson and store in array
		JSONArray hoursArray = forecastDayJson.getJSONArray("hour");

		// Initialize variables to keep track of the most feels like temperature
		double maxFeelsLikeTemperature = Double.MIN_VALUE;

		// Iterate through each hour to find the maximum feels like temperature
		for (int i = 0; i < hoursArray.length(); i++) {
			JSONObject hourData = hoursArray.getJSONObject(i);
			double feelsLikeTemperature = hourData.getDouble("feelslike_c");
			if (feelsLikeTemperature > maxFeelsLikeTemperature) {
				maxFeelsLikeTemperature = feelsLikeTemperature;
			}
		}

		return maxFeelsLikeTemperature;
	}
	public String getWeatherCondition() {
		/*
		 * method to return the weather condition as String from the JSON object in
		 * forecastDayJson
		 */
		return forecastDayJson.getJSONObject("day").getJSONObject("condition").getString("text");
	}

	public double getWind() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getWind'");
	}
}
