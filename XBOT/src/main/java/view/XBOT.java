package view;

import java.util.Calendar;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import clothing.Recommendation;

public class XBOT extends JPanel implements ActionListener{
	private PlaceholderTextField inputField; // Declaration of PlaceholderTextField object
	private JTextArea chatArea; // Declaration of JTextArea object
	private JScrollPane scrollPane; // Declaration of JScrollPane object

	// Constructor for XBOT
	public XBOT() {
		setLayout(new BorderLayout()); // Setting the layout manager for the panel

        /*
         * Create input field with placeholder text
         */
        inputField = new PlaceholderTextField("Type here"); // Initializing the input field with placeholder text
        inputField.addActionListener(this); // Adding an action listener to the input field
        inputField.setFont(new Font("Arial", Font.BOLD, 22)); // Setting the font size for the input field

        /*
         * Create OK button
         */
        JButton okButton = new JButton("OK"); // Creating an OK button
        okButton.addActionListener(this); // Adding an action listener to the OK button

        /*
         * Create input panel to hold input field and OK button
         */
        JPanel inputPanel = new JPanel(new BorderLayout()); // Creating a panel to hold the input field and OK button
        inputPanel.add(inputField, BorderLayout.CENTER); // Adding the input field to the input panel
        inputPanel.add(okButton, BorderLayout.EAST); // Adding the OK button to the input panel

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

        /*
         * Add components to panel
         */
        add(inputPanel, BorderLayout.SOUTH); // Adding the input panel to the bottom of the panel
        add(scrollPane, BorderLayout.CENTER); // Adding the scroll pane containing the chat area to the center of the panel

        // Greet the user based on the time of day
        chatArea.append("XBOT: " + generateGreeting() + "\n"); // Displaying a greeting message
        xbotReply("Enter the destination"); // Displaying a message from XBOT
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



}
