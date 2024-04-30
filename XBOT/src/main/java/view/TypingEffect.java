package view;

import java.util.List;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

public class TypingEffect extends SwingWorker<Void, Character>{
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'doInBackground'");
    }


    @Override
    protected void process(List<Character> chunks) {
        
    }

}
