package clothing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RecommendationTest {

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
	public void testGetRecommendation() {
		Recommendation recommendation = new Recommendation();
		
		// Test with a specific city name
        String cityName = "London";
        String result = recommendation.getRecommendation(cityName);

        // Check if the result is not null
        assertNotNull(result);

        assertNotEquals("", recommendation.getRecommendation(cityName));
    }
	
	

	@Test
	public void testGenerateDate() {
		Recommendation recommendation = new Recommendation();

		// test with specific date string
		String dateString = "2024-04-15";
		String expected = "April 15, 2024";
		String result = recommendation.generateDate(dateString);

		// check if the result is not null
		assertNotNull(result);

		//
		assertEquals(expected, result);
	}

	

	@Test
	public void clothesTest() {
		// Test cases for different temperature, weather conditions, and wind speeds
		assertEquals("Its hot! Wear light clothes, like shorts and t-shirt.",
				Recommendation.clothes(25.0, "Sunny", 5.0)); // Light wind, hot temperature
		assertEquals("Its warm, not hot. Wear light with light jacket.",
				Recommendation.clothes(18.0, "Partly cloudy", 15.0)); // Moderate wind, warm temperature
		assertEquals("Its bit cold. Wear warm, like long-sleeved shirt with sweater & jacket. ",
				Recommendation.clothes(8.0, "Cloudy with showers", 30.0)); // Strong wind, cold temperature
		assertEquals("IT IS STORM! Stay at home!",
				Recommendation.clothes(8.0, "Cloudy with showers", 120.0));// Storm
	}

}
