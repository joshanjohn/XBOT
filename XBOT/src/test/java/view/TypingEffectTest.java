package view;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.JTextArea;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TypingEffectTest {

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
    public void testDoInBackground() {
        // Create a JTextArea for testing
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        // Create a TypingEffect instance
        String message = "Hello, world!";
        int typingSpeed = 50; // milliseconds
        TypingEffect typingEffect = new TypingEffect(textArea, message, typingSpeed);

        // Execute doInBackground method
        try {
            typingEffect.doInBackground();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Wait for the typing effect to complete
        try {
            TimeUnit.MILLISECONDS.sleep(message.length() * typingSpeed); // Wait for the typing to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verify that the textArea contains the entire message
        assertEquals(message, textArea.getText().trim());
    }

    @Test
    public void testProcess() {
        // Create a JTextArea for testing
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        // Create a list of characters to simulate chunks
        List<Character> chunks = new ArrayList<>();
        chunks.add('H');
        chunks.add('e');
        chunks.add('l');
        chunks.add('l');
        chunks.add('o');
        chunks.add(',');
        chunks.add(' ');
        chunks.add('w');
        chunks.add('o');
        chunks.add('r');
        chunks.add('l');
        chunks.add('d');
        chunks.add('!');

        // Create a TypingEffect instance
        TypingEffect typingEffect = new TypingEffect(textArea, "", 0);

        // Execute process method
        typingEffect.process(chunks);

        // Verify that the textArea contains the entire message
        assertEquals("Hello, world!", textArea.getText().trim());
    }

}
