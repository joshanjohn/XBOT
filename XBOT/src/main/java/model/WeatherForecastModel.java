package model;

import org.json.JSONObject;

import org.json.JSONObject;

public class WeatherForecastModel {
	// attribute for forecastData
	private final JSONObject forecastData;

	// Constructor for WeatherForecastModel
	public WeatherForecastModel(String forecastJson) {
		this.forecastData = new JSONObject(forecastJson);
	}
}
