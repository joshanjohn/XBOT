package model;

import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONObject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import weather.WeatherApiConnection;

class ForecastDayModelTest {

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
	public void testGetWeatherCondition(){
		WeatherApiConnection weatherApiConnection = new WeatherApiConnection("Dublin", 3);
		try{

			assertNotNull(weatherApiConnection.getWeatherData());

			assertEquals("String", weatherApiConnection.getWeatherData().getClass().getSimpleName());

			WeatherApiConnection weatherApiConnection2 = new WeatherApiConnection("Cork", 3);

			assertNotEquals(weatherApiConnection.getWeatherData(), weatherApiConnection2.getWeatherData());
		}catch(Exception e){
			fail("Fail to parse json string");
		}
	}


    @Test
    public void testGetDate() {
        // Test case 1: Valid date
        JSONObject forecastDayJson1 = new JSONObject();
        forecastDayJson1.put("date", "2024-04-01");

        ForecastDayModel forecastDayModel1 = new ForecastDayModel(forecastDayJson1);
        assertEquals("2024-04-01", forecastDayModel1.getDate());

        // Test case 2: Null date
        JSONObject forecastDayJson2 = new JSONObject();
        forecastDayJson2.put("date", JSONObject.NULL);

        ForecastDayModel forecastDayModel2 = new ForecastDayModel(forecastDayJson2);
        assertNull(forecastDayModel2.getDate());

        // Test case 3: Empty date
        JSONObject forecastDayJson3 = new JSONObject();
        forecastDayJson3.put("date", "");

        ForecastDayModel forecastDayModel3 = new ForecastDayModel(forecastDayJson3);
        assertEquals("", forecastDayModel3.getDate());
    }

    @Test
    public void testGetWind() {
        // Test cases
        JSONObject[] testJsonObjects = {
                new JSONObject().put("maxwind_kph", 20.5), // Test case 1: Wind speed is 20.5 kph
                new JSONObject().put("maxwind_kph", 15.3), // Test case 2: Wind speed is 15.3 kph
                new JSONObject().put("maxwind_kph", 30.0) // Test case 3: Wind speed is 30.0 kph
        };

        // Perform tests for each test case
        for (JSONObject jsonObject : testJsonObjects) {
            ForecastDayModel instance = new ForecastDayModel(jsonObject);
            double expectedWindSpeed = jsonObject.getDouble("maxwind_kph");

            double actualWindSpeed = instance.getWind();
            assertEquals(expectedWindSpeed, actualWindSpeed, 0.01);
        }
    }

    @Test
    public void testGetMostFeelsLikeTemperature() {
        // Mock forecastDayJson for testing
        JSONObject forecastDayJson = new JSONObject(
                "{\"hour\": [{\"feelslike_c\": 20.0}, {\"feelslike_c\": 22.5}, {\"feelslike_c\": 19.8}]}");

        // Instantiate ForecastDayModel object
        ForecastDayModel forecastDayModel = new ForecastDayModel(forecastDayJson);

        // Expected maximum feels like temperature
        double expected = 22.5;

        // test for not null
        assertNotEquals(expected, forecastDayJson);
        
        // Test multiple cases using a for loop
        assertEquals(expected, forecastDayModel.getMostFeelsLikeTemperature());

    }

}
