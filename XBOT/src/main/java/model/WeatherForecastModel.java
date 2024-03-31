package model;

import org.json.JSONArray;
import org.json.JSONObject;

public class WeatherForecastModel{
    private final JSONObject forecastData ;

    // Constructor for WeatherForecastModel
	public WeatherForecastModel(String forecastJson) {
		this.forecastData = new JSONObject(forecastJson);
	}

	public ForecastDayModel getForecastDay(int index) {
		/*
		 * Method to get the forecast data for a specific day. The index use an index
		 * value to specify the day
		 */
		return null;
	}

}
