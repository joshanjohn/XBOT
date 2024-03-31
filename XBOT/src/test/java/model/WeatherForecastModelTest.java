package model;

import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WeatherForecastModelTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
    public void testGetForecastDay() {
        // Create a mock forecast data JSON
        JSONObject forecastData = new JSONObject();
        JSONObject forecast = new JSONObject();
        JSONArray forecastday = new JSONArray();
        JSONObject forecastDay1 = new JSONObject();
        // Populate forecastDay1 with necessary data for testing
        forecastday.put(forecastDay1);
        forecast.put("forecastday", forecastday);
        forecastData.put("forecast", forecast);

        // Convert forecastData to a string
        String forecastDataString = forecastData.toString();

        // Create an instance of WeatherForecastModel with forecastDataString as argument
        WeatherForecastModel instance = new WeatherForecastModel(forecastDataString);

        // Test the method with index 0
        ForecastDayModel result = instance.getForecastDay(0);

        // Assert that the result is not null
        assertNotNull(result);

    }

}
