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

}
