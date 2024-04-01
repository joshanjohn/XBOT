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
		JSONArray forecastDays = forecastData.getJSONObject("forecast").getJSONArray("forecastday");
		JSONObject forecastDayJson = forecastDays.getJSONObject(index); // getting JSON for specific index
		return new ForecastDayModel(forecastDayJson);
	}

}
