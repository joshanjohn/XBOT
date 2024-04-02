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

	public double getWind() {
		/*
		 * method to return the wind speed in kph.
		 */
		return forecastDayJson.getJSONObject("day").getDouble("maxwind_kph");
	}

	
	public String getWeatherCondition() {
		/*
		 * method to return the weather condition as String from the JSON object in
		 * forecastDayJson
		 */
		return forecastDayJson.getJSONObject("day").getJSONObject("condition").getString("text");
	}

	
}
