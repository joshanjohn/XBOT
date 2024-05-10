package validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Validation.Validation;

class ValidationTest {

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
    public void testIsValidCity() {
        Validation validator = new Validation();

        // Test valid city names
        assertTrue(validator.isValidCity("New York"));
        assertTrue(validator.isValidCity("Los Angeles"));
        assertTrue(validator.isValidCity("San Francisco"));

        // Test invalid city names
        assertFalse(validator.isValidCity("123 City"));
        assertFalse(validator.isValidCity("City$Name"));
        assertFalse(validator.isValidCity("123"));
    }

	@Test
    public void testRemoveSpace() {
        // Test with leading and trailing spaces
        String input1 = "  new york  ";
        String expectedOutput1 = "new-york";
        String actualOutput1 = Validation.removeSpace(input1);
        assertEquals(expectedOutput1, actualOutput1);
        
        // Test with an empty string
        String input2 = "";
        String expectedOutput2 = "";
        String actualOutput2 = Validation.removeSpace(input2);
        assertEquals(expectedOutput2, actualOutput2);
        
        // Test with no spaces
        String input3 = "hello";
        String expectedOutput3 = "hello";
        String actualOutput3 = Validation.removeSpace(input3);
        assertEquals(expectedOutput3, actualOutput3);
    }

}
