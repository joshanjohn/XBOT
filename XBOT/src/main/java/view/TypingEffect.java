package view;

import javax.swing.*;
import java.util.List;

public class TypingEffect extends SwingWorker<Void, Character> {
    private JTextArea textArea;
    private String message;
    private int typingSpeed;

    public TypingEffect(JTextArea textArea, String message, int typingSpeed) {
        this.textArea = textArea;
        this.message = message;
        this.typingSpeed = typingSpeed;
    }

    @Override
    protected Void doInBackground() throws Exception {
        for (char c : message.toCharArray()) {
            publish(c);
            Thread.sleep(typingSpeed);
        }
        return null;
    }

    @Override
    protected void process(List<Character> chunks) {
        StringBuilder sb = new StringBuilder();
        for (Character c : chunks) {
            sb.append(c);
        }
        textArea.append(sb.toString());
    }
}

