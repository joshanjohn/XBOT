package view;

import javax.swing.*;
import java.awt.*;

public class XBOTWrapper extends JPanel {
    public XBOTWrapper() {
        setLayout(new BorderLayout()); // Setting BorderLayout for the wrapper panel
        setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 20)); // Adding padding to the wrapper panel
        
        // Creating and adding XBOT panel
        XBOT xbot = new XBOT();
        add(xbot, BorderLayout.CENTER); // Adding XBOT panel to the center of the wrapper panel
    }
}
