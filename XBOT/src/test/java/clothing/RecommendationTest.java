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
	public void testWeatherSummary() {
		// Instantiate the Recommendation class
		Recommendation recommendation = new Recommendation();

		// Define test input values
		String date = "2024-04-15";
		String temp = "20";
		String condition = "Sunny";
		Double wind = 10.5;

		// Define expected and unexpected output strings
		String expected = "\n\t> On April 15, 2024, the weather with most feel like \n\ttemperature of 20°C, \n\taccompanied by Sunny weather conditions and \n\ta wind speed of 10.5km/h.";
		String unexpected = "\n\t> On March 15, 2024, the weather with most feel like \n\ttemperature of 89°C, \n\taccompanied by Sunny weather conditions and \n\ta wind speed of 10.5km/h.";

		// Assert that the generated weather summary is not null
		assertNotNull(recommendation.weatherSummary(date, temp, condition, wind));

		// Assert that the generated weather summary matches the expected output
		assertEquals(expected, recommendation.weatherSummary(date, temp, condition, wind));

		// Assert that the generated weather summary is not equal to the unexpected
		// output
		assertNotEquals(unexpected, recommendation.weatherSummary(date, temp, condition, wind));

	}

	@Test
	public void testGenerateDate() {
		Recommendation recommendation = new Recommendation();

		// test with specific date string
		String dateString = "2022-04-15";
		String expected = "April 15,2024";
		String result = recommendation.generateDate(dateString);

		// check if the result is not null
		assertNotNull(result);

		//
		assertEquals(expected, result);
	}

}
