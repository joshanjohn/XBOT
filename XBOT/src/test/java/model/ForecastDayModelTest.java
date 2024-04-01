package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import weather.WeatherApiConnection;

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

	
// 	@Test
// 	public void testGetWeatherCondition(){
// 		WeatherApiConnection weatherApiConnection = new WeatherApiConnection("Dublin", 3);
// 		try{

// 			assertNotNull(weatherApiConnection.getWeatherCondition());

// 			assertEquals("String", weatherApiConnection.getWeatherCondition().getClass().getSimpleName());

// 			WeatherApiConnection weatherApiConnection2 = new WeatherApiConnection("Cork", 3);

// 			assertNotEquals(weatherApiConnection.getWeatherCondition(), weatherApiConnection2.getWeatherCondition());
// 		}catch(Exception e){
// 			fail("Fail to parse json string");
// 		}
// 	}
}

