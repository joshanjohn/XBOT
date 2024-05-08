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
                BorderFactory.createEmptyBorder(5, 10, 5, 10) // Inner margin
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

   private boolean sendMessage(String input) {
        if (userName == null) {
            // If we haven't got the user's name yet, set it and greet them personally
            userName = input;
            chatArea.append("You: " + userName + "\n");
            xbotReply("Hello, " + userName + "! "+ " Such a lovely name");
            xbotReply("Enter the location to get weather reoprts");
            return true; // Successfully set user's name
        } else {
            try {
                chatArea.append("You: " + input + "\n");
                inputField.setText("");
                String r = Recommendation.getRecommendation(input);
                xbotReply(r);
                xbotReply("Enter the city name to get weather reoprts");
                return true; // Successfully sent message and received response
            } catch (Exception e) {
                xbotReply("Sorry, I couldn't process your request. Please try again.");
                return false; // Error occurred while processing message
            }
        }
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == inputField || e.getActionCommand().equals("OK")) {
            String input = inputField.getText().trim();
            if (!input.isEmpty() && !input.equals("Type here")) {
                if (destinationEntered) {
                    sendMessage(input);
                    destinationEntered = false;
                } else {
                    sendMessage(input);
                    destinationEntered = true;
                }
            }
        }
    }
}
