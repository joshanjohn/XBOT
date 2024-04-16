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
                return;
            }

            @Override
            public void focusLost(FocusEvent e) {
                return;
            }
        });
    }

}
