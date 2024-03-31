package weather;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WeatherAnalyzerTest {

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
	 * test for getWeatherForecastModel method
	 */
	@Test
	void testGetWeatherForecastModel() {
		try {
			WeatherAnalyzer analyzer = new WeatherAnalyzer("London", 3);

			// test for null checking
			assertNotNull(analyzer.getWeatherForecastModel());

			// testing for getting sub methods (getDate method)
			String expedDateToday = LocalDate.now().toString(); // expected todays Date
			String actualDateToday = analyzer.getWeatherForecastModel().getForecastDay(0).getDate(); // actual todayda
			// date from API
			assertEquals(expedDateToday, actualDateToday);

		} catch (Exception e) {
			fail("getWeatherForecastModel method failed");
		}
	}

}
