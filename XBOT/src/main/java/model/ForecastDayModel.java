package model;

import org.json.JSONArray;
import org.json.JSONObject;

public class ForecastDayModel {
    private final JSONObject forecastDayJson ;
    
    // Constructor to initialize the ForecastDayModel with forecast day JSON data
	public ForecastDayModel(JSONObject forecastDayJson) {
		this.forecastDayJson = forecastDayJson;
	}

	public String getWeatherCondition(){
		/*
		 * method to return the weather condition as String from the JSON object in
		 * forecastDayJson
		 */
		return null;
	}
}
