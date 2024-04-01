package model;

import org.json.JSONArray;
import org.json.JSONObject;

public class ForecastDayModel {
    private final JSONObject forecastDayJson ;
    
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

	public double getWind(){
		/*
		 * method to return the wind speed in kph.
		 */
		return 0.0;
	}


	public double getMostFeelsLikeTemperature() {
		/*
		 * method to return the most feels like temperature in celcius.
		 */
		return 0.0;
	}
}