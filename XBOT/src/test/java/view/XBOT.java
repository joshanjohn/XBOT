package view;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import javax.swing.JTextArea;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class XBOTTest {

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
	void testGenerateGreeting() {
		XBOT xbot = new XBOT();
		// testing if the generateGreeting method
		assertNotNull(xbot.generateGreeting()); // check if there is any out put

		// testing the method greetings
		String expectedGreeting;
		Calendar calendar = Calendar.getInstance(); // Getting the current calendar instance
		int hour = calendar.get(Calendar.HOUR_OF_DAY); // Getting the current hour of the day
		if (hour >= 0 && hour < 12) { // Checking if it's morning
			expectedGreeting = "Good morning!"; // expected Greeting is morning greeting
		} else if (hour >= 12 && hour < 18) { // Checking if it's afternoon
			expectedGreeting = "Good afternoon!"; // expected Greeting is afternoon greeting
		} else { // Assuming it's evening
			expectedGreeting = "Good evening!"; // expected Greeting is evening greeting
		}

		assertEquals(expectedGreeting, xbot.generateGreeting());
	}

	//test method for xbotReply
	@Test
	void testXbotReply() throws NoSuchFieldException, IllegalAccessException {
		//Creating new XBOT
		XBOT xbot = new XBOT();
		//Creating a JTextArea to simulate the chat area
		JTextArea chatArea = new JTextArea(); 

		// Using reflection to access the private field chatArea
		java.lang.reflect.Field field = XBOT.class.getDeclaredField("chatArea");
		field.setAccessible(true);
		field.set(xbot, chatArea);

		String message = "Test message";

		//Test case
		xbot.xbotReply(message);
		String expected = "XBOT: " + message + "\n";
		assertEquals(expected, chatArea.getText());
	}

}