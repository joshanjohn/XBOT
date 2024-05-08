package view;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import clothing.Recommendation;

public class XBOT extends JPanel implements ActionListener {
    private PlaceholderTextField inputField;
    private JTextArea chatArea;
    private JScrollPane scrollPane;
    private boolean destinationEntered = false;
    private String userName; // Store user's name for personalization *

    public XBOT() {
        setLayout(new BorderLayout());

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        chatArea.setFont(new Font("Arial", Font.PLAIN, 16));

        scrollPane = new JScrollPane(chatArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        inputField = new PlaceholderTextField("Type here");
        inputField.addActionListener(this);
        inputField.setFont(new Font("Arial", Font.BOLD, 22));

        // Increase the size of the input field
        inputField.setPreferredSize(new Dimension(300, 80)); // Increase the height to 80 pixels

        // Add a border around the input field
        inputField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 2), // Outer border
                BorderFactory.createEmptyBorder(5, 5, 5, 5) // Inner margin
        ));

        // Create OK button
        JButton okButton = new JButton("OK");
        okButton.addActionListener(this);

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(okButton, BorderLayout.EAST);
        inputPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        // Greet the user based on the time of day
        chatArea.append("XBOT: " + generateGreeting() + "\n"); // Displaying a greeting message
        xbotReply("I am XBOT. I will be giving you the weather forecast.");
        xbotReply("Enter your name");
        inputField.setText("");
    }

    protected String generateGreeting() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        String greeting;

        if (hour >= 5 && hour < 12) {
            greeting = "Good morning!";
        } else if (hour >= 12 && hour < 17) {
            greeting = "Good afternoon!";
        } else if (hour >= 17 && hour < 21) {
            greeting = "Good evening!";
        } else {
            greeting = "Good night!";
        }

        return greeting;
    }

    // Prints the reply for user
    public void xbotReply(String message) {
        chatArea.append("XBOT: " + message + "\n"); // Displaying XBOT's message in the chat area
    }

   
