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
	public void testHotDay() {
		String recommendation = Recommendation.clothes(30.0, "Sunny", 10.0);
		assertEquals("It's a hot day! Wear something light like shorts and t-shirt.", recommendation);
	}

	@Test
	public void testWarmDay() {
		String recommendation = Recommendation.clothes(25.0, "Sunny", 10.0);
		assertEquals("Its warm, not hot. I recommend to wear something light but with jacket.", recommendation);
	}

	@Test
	public void testColdDay() {
		String recommendation = Recommendation.clothes(10.0, "Cloudy", 10.0);
		assertEquals("It's a bit cold. Wear something warm, like long-sleeved shirt with sweater & jacket. ",
				recommendation);
	}

	@Test
	public void testFreezingDayWithWind() {
		String recommendation = Recommendation.clothes(0.0, "Snowy", 20.0);
		assertEquals(
				"Its freezing! Wear really warm. Get gloves, scarf & cap. Also, due to wind it may feel a little bit coolerEXTRA RECOMENDATION :) It s snowing so go and build a snowman",
				recommendation);
	}

	@Test
	public void testRainyDay() {
		String recommendation = Recommendation.clothes(15.0, "Rainy", 10.0);
		assertEquals(
				"It's a bit cold. Wear something warm, like long-sleeved shirt with sweater & jacket. Don't forget about umbrella!",
				recommendation);
	}

	@Test
	public void testSunnyDayWithCap() {
		String recommendation = Recommendation.clothes(28.0, "Sunny", 10.0);
		assertEquals(
				"It's a hot day! Wear something light like shorts and t-shirt.I also recommend you to take the cap",
				recommendation);
	}

	@Test
	public void testStormyDay() {
		String recommendation = Recommendation.clothes(20.0, "Stormy", 30.0);
		assertEquals("IT IS STORM! I highly recommend you to stay at home.", recommendation);
	}

}
