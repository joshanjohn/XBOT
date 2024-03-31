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
		return null;

	}
}