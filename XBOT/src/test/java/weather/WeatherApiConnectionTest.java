package weather;

import static org.junit.jupiter.api.Assertions.*;

import java.net.HttpURLConnection;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WeatherApiConnectionTest {

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

	/*
	 * method to test connect method
	 */
	@Test
	void testConnect() {
		WeatherApiConnection weather = new WeatherApiConnection("London", 3);
		try {
			// testing if the connect method
			assertNotNull(weather.connect());

			// testing if the responce status is ok (means 200)
			assertEquals(HttpURLConnection.HTTP_OK, weather.connect().getResponseCode(),
					"Response code should be HTTP_OK");
		} catch (Exception e) {
			fail("test connect failed");
		}
	}

	/*
	 * method to test getCityName method
	 */
	@Test
	public void testGetCityName() {
		String expectedCityName1 = "Dublin";
		String expectedCityName2 = "";
		int days = 3;
		// instance with city name
		WeatherApiConnection weatherApiConnection1 = new WeatherApiConnection("Dublin", days);
		// instance without city name
		WeatherApiConnection weatherApiConnection2 = new WeatherApiConnection("", days);

		// test 1
		String result1 = weatherApiConnection1.getCityName();
		assertEquals(expectedCityName1, result1);

		// test 2
		String result2 = weatherApiConnection2.getCityName();
		assertEquals(expectedCityName2, result2);
	}

	@Test
	public void testGetWeatherData() throws Exception{
    String expectedWeatherData = "\n Temperature:- 15 \n Data:- Cloudy";
	try{
    WeatherApiConnection weatherApiConnection = new WeatherApiConnection("Dublin", 3);

	assertNotNull(weatherApiConnection.getWeatherData());

	assertEquals("String",weatherApiConnection.getWeatherData().getClass().getSimpleName());

	WeatherApiConnection  weatherApiConnection2 = new WeatherApiConnection("Cork", 3);

	
	assertNotEquals(weatherApiConnection.getWeatherData(),weatherApiConnection2.getWeatherData());
	}catch(Exception e){
		fail();
	}
    
}

}
