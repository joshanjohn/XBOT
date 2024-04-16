package view;


import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class PlaceholderTextField extends JTextField {
    public PlaceholderTextField(String placeholder) {
        setForeground(Color.GRAY); // Set text color to gray
        setText(placeholder);
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (getText().equals(placeholder)) {
                    setForeground(Color.BLACK); // Change text color to black when focused
                    setText(""); // Clear text when focused
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (getText().isEmpty()) {
                    setForeground(Color.GRAY); // Reset text color to gray if no text entered
                    setText(placeholder); // Set placeholder text if no text entered
                }            
            }
        });
    }

}
