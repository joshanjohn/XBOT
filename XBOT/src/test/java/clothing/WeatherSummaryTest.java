package clothing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WeatherSummaryTest {

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
        // Instantiate the WeatherSummary class
        WeatherSummary summary = new WeatherSummary();

        // Define test input values
        String date = "2024-04-15";
        Double temp = 20.0;
        String condition = "Sunny";
        Double wind = 10.5;

        // Define expected and unexpected output strings
        String expected = "\n\t> On April 15, 2024, -> 20.0°C, \n\taccompanied by Sunny weather conditions and \n\ta wind speed of 10.5km/h.";
        String unexpected = "\n\t> On March 15, 2024, the weather with most feel like \n\ttemperature of 89.0°C, \n\taccompanied by Sunny weather conditions and \n\ta wind speed of 10.5km/h.";

        // Assert that the generated weather summary is not null
        assertNotNull(summary.weatherSummary(date, temp, condition, wind));

        // Assert that the generated weather summary matches the expected output
        assertEquals(expected, summary.weatherSummary(date, temp, condition, wind));

        // Assert that the generated weather summary is not equal to the unexpected output
        assertNotEquals(unexpected, summary.weatherSummary(date, temp, condition, wind));
    }

	@Test
	public void testAnalyseWind() {
		// Test cases for different wind speeds
		assertEquals(1, WeatherSummary.analyseWind(0.5)); // Light wind
		assertEquals(1, WeatherSummary.analyseWind(3.0)); // Light wind
		assertEquals(2, WeatherSummary.analyseWind(25.0)); // Moderate wind
		assertEquals(3, WeatherSummary.analyseWind(80.0)); // Strong wind
		assertEquals(4, WeatherSummary.analyseWind(110.0));// Very strong wind
	}

	@Test
    public void testIsRaining() {
        // Test case 1: Weather condition contains "rainy"
        assertTrue(WeatherSummary.isRaining("Heavy Rainy")); // Should return true

        // Test case 2: Weather condition contains "rain"
        assertTrue(WeatherSummary.isRaining("Scattered showers and rain")); // Should return true

        // Test case 3: Weather condition does not contain "rainy" or "rain"
        assertFalse(WeatherSummary.isRaining("Partly cloudy")); // Should return false

        // Test case 4: Weather condition is empty
        assertFalse(WeatherSummary.isRaining("")); // Should return false

        // Test case 5: Weather condition is null
        assertFalse(WeatherSummary.isRaining(null)); // Should return false
    }



}
