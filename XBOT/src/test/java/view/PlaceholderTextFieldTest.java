package view;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.Dimension;
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

	@Test
    public void testGetPreferredSize() {
        PlaceholderTextField component = new PlaceholderTextField("placeholder"); 
		//Original preffered size
        Dimension originalPreferredSize = component.getPreferredSize();
        //New preffered size
        Dimension newPreferredSize = component.getPreferredSize();
        
        // Test 1: checking if the width remains the same
        assertEquals(originalPreferredSize.width, newPreferredSize.width);
        
        // Test 2: checking  if the height is now 30 pixels
        assertEquals(30, newPreferredSize.height);
    }
}
