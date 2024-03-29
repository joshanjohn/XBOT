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

	@Test
	public void testGetCityName() 
	{
        String cityName = "Dublin";
        int days = 3;
        WeatherApiConnection weatherApiConnection = new WeatherApiConnection(cityName, days);
        
        String result = weatherApiConnection.getCityName();
        
        assertEquals(cityName, result);
    }

}
