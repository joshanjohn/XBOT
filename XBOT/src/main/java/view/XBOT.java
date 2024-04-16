package view;

import java.util.Calendar;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class XBOT extends JPanel {
	private PlaceholderTextField inputField; // Declaration of PlaceholderTextField object
	private JTextArea chatArea; // Declaration of JTextArea object
	private JScrollPane scrollPane; // Declaration of JScrollPane object

	// Constructor for XBOT
	public XBOT() {
		/*
		 * Create OK button
		 */
		JButton okButton = new JButton("OK"); // Creating an OK button

		/*
		 * Create chat area with line wrap
		 */
		chatArea = new JTextArea(); // Creating a JTextArea for displaying chat messages
		chatArea.setEditable(false); // Making the chat area non-editable
		chatArea.setLineWrap(true); // Enabling line wrap for the chat area
		chatArea.setFont(new Font("Arial", Font.PLAIN, 16)); // Setting the font size for the chat area

		/*
		 * Create scroll pane for the chat area
		 */
		scrollPane = new JScrollPane(chatArea); // Creating a JScrollPane to scroll the chat area
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // Setting vertical scroll policy

		add(scrollPane, BorderLayout.CENTER); // Adding the scroll pane containing the chat area to the center of the
												// panel
	}

	// Generates greeting according to current time of day
	protected String generateGreeting() {
		Calendar calender = Calendar.getInstance(); // getting the current calendar instance
		int hour = calender.get(Calendar.HOUR_OF_DAY); // getting the current time of the day
		if (hour >= 6 && hour < 12) { // checking if its morning
			return "Good morning";
		} else if (hour >= 12 && hour < 18) {// checking if its afternoon
			return "Good afternoon!";
		} else { // assuming its evening
			return "Good evening!";
		}
	}

	// Prints the reply for user
	public void xbotReply(String message) {
        chatArea.append("XBOT: " + message + "\n"); // Displaying XBOT's message in the chat area
    }

}
