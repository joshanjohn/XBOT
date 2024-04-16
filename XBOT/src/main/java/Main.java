import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import view.XBOT;




public class Main {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new JFrame("XBOT"); // Creating a new JFrame
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Setting the default close operation
			frame.setSize(800, 720); // Setting the size of the frame
			frame.getContentPane().add(new XBOT()); // Adding an instance of XBOT to the frame
			frame.setVisible(true); // Making the frame visible
		});
	}
}
