package view;

import javax.swing.JTextArea;

public class TypingEffect {
    private JTextArea textArea;
    private String message;
    private int typingSpeed;

    public TypingEffect(JTextArea textArea, String message, int typingSpeed) {
        this.textArea = textArea;
        this.message = message;
        this.typingSpeed = typingSpeed;
    }
}
