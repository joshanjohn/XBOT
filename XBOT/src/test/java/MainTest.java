import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MainTest {

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
	void testCloth() {

		Main main = new Main();
		// Test cases with array of values: {temperature, weather condition, expected
		// recommendation}
		Object[][] testData = {
				{ 25.0, "sunny",
						"It is hot! Wear something light, like shorts and t-shirt. Don't forget about headdress. " },
				{ 18.0, "cloudy", "It is warm, but not hot. Wear something light but take the jacket." },
				{ 18.0, "rainy",
						"It is warm, but not hot. Wear something light but take the jacket.It is also rainy, so don't forget about umbrella!" },
				{ 5.0, "cloudy", "It is cold! Wear something warm, like sweater, topped with warm jacket and jeans. " },
				{ 14.0, "rainy day",
						"It is a little bit cold. Wear something light that warms you, like a long-sleeved shirt with a sweater or fleece, topped with a jacket. It is also rainy, so don't forget about umbrella!" },
				{ -12.0, "cloudy",
						"It is freezing! Wear something really warm. Don't forget about the gloves, a scarf and a cap. " },
				{ -12.0, "Rain",
						"It is freezing! Wear something really warm. Don't forget about the gloves, a scarf and a cap. It is also rainy, so don't forget about umbrella!" },
				{ 0.0, "sunny", "It is cold! Wear something warm, like sweater, topped with warm jacket and jeans. " },
		};

		for (Object[] data : testData) {
			Double temp = (Double) data[0];
			String weatherCondition = (String) data[1];
			String expectedRecommendation = (String) data[2]; // expected cloth recommendation

			String actualRecommendation = main.clothes(temp, weatherCondition); // actual recommendation

			// test for null
			assertNotNull(actualRecommendation);

			// test for array of values
			assertEquals(expectedRecommendation, actualRecommendation);
		}

	}

}
