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

}
