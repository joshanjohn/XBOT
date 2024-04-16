package view;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.event.FocusListener;

class PlaceholderTextFieldTest {

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
    void testAddFocusListener() {
		PlaceholderTextField textField = new PlaceholderTextField("Enter text here");

		// Get the focus listeners added to the text field
		FocusListener[] focusListeners = textField.getFocusListeners();

		// Check if there is at least one focus listener
		assertTrue(focusListeners.length > 0);

		// Check if the first focus listener is an instance of FocusListener
		assertTrue(focusListeners[0] instanceof FocusListener);
	}
}
