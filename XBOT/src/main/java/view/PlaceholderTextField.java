package view;


import javax.swing.*;
import java.awt.*;

public class PlaceholderTextField extends JTextField {
    public PlaceholderTextField(String placeholder) {
        setForeground(Color.GRAY); // Set text color to gray
        setText(placeholder);
    }

}
