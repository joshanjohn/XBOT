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
    public void testClothes() {
        // Test case 1
        String recommendation1 = Recommendation.clothes(30.0, "Sunny", 10.0);
        assertEquals("It's a hot day! Wear something light like shorts and t-shirt. \n" + //
						"\tI also recommend you to take the cap.", recommendation1);

        // Test case 2
        String recommendation3 = Recommendation.clothes(10.0, "Rainy", 5.0);
        assertEquals("It's a bit cold. Wear something warm, like long-sleeved shirt with sweater & jacket. \n" + //
						"\tDon't forget about the umbrella!", recommendation3);

        // Test case 3
        String recommendation4 = Recommendation.clothes(0.0, "Snowy", 15.0);
        assertEquals("It's cold! Wear something warm, like sweater & warm jacket. \n" + //
						"\tEXTRA RECOMENDATION :) It s snowing, so try to build a snowman!!", recommendation4);

    }

}
