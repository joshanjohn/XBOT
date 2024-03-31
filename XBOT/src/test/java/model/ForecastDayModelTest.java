package model;

import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONObject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ForecastDayModelTest {

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
    public void testGetDate() {
        // Test case 1: Valid date
        JSONObject forecastDayJson1 = new JSONObject();
        forecastDayJson1.put("date", "2024-04-01");

        ForecastDayModel forecastDayModel1 = new ForecastDayModel(forecastDayJson1);
        assertEquals("2024-04-01", forecastDayModel1.getDate());

        // Test case 2: Null date
        JSONObject forecastDayJson2 = new JSONObject();
        forecastDayJson2.put("date", JSONObject.NULL);

        ForecastDayModel forecastDayModel2 = new ForecastDayModel(forecastDayJson2);
        assertNotNull(forecastDayModel2.getDate());

        // Test case 3: Empty date
        JSONObject forecastDayJson3 = new JSONObject();
        forecastDayJson3.put("date", "");

        ForecastDayModel forecastDayModel3 = new ForecastDayModel(forecastDayJson3);
        assertEquals("", forecastDayModel3.getDate());
    }

}
