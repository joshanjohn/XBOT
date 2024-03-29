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
	public void testGetCityName() 
	{
        String cityName1 = "Dublin";
		String cityName2 = "";
        int days = 3;
		//instance with city name
        WeatherApiConnection weatherApiConnection1 = new WeatherApiConnection(cityName1, days);
		//instance without city name
		WeatherApiConnection weatherApiConnection2 = new WeatherApiConnection(cityName2,days);

		//test 1
        String result1 = weatherApiConnection1.getCityName();
        assertEquals(cityName1, result1);

		//test 2
		String result2 = weatherApiConnection2.getCityName();
		assertEquals(cityName2, result2);
    }

	
}


