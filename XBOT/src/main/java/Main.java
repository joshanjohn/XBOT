import javax.swing.*;
import java.awt.*;

import view.XBOT;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("XBOT"); // Creating a new JFrame
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Setting the default close operation

            // Create a wrapper panel with padding
            JPanel wrapperPanel = new JPanel(new BorderLayout()); // Creating a JPanel with BorderLayout
            wrapperPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Adding padding to the wrapper panel

            wrapperPanel.add(new XBOT()); // Adding an instance of XBOT to the wrapper panel
            frame.getContentPane().add(wrapperPanel); // Adding the wrapper panel to the content pane of the frame

            frame.setSize(800, 720); // Setting the size of the frame
            frame.setVisible(true); // Making the frame visible
        });
    }
}
