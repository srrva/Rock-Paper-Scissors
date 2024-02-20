package pack;

import javax.swing.*;
import java.awt.*;

public class StatsPanel extends JPanel {
    private JLabel playerWinsLabel, computerWinsLabel, tiesLabel;
    private JTextField playerWinsField, computerWinsField, tiesField;

    // Counts for wins and ties
    private int playerWins;
    private int computerWins;
    private int ties;

    // Constructor to initialize the components
    public StatsPanel() {
        // Set layout for the panel
        setLayout(new GridLayout(3, 2));

        // Create labels
        playerWinsLabel = new JLabel("Player Wins:");
        computerWinsLabel = new JLabel("Computer Wins:");
        tiesLabel = new JLabel("Ties:");

        // Create text fields to display counts
        playerWinsField = new JTextField(5);
        playerWinsField.setEditable(false); // Make it non-editable
        computerWinsField = new JTextField(5);
        computerWinsField.setEditable(false); // Make it non-editable
        tiesField = new JTextField(5);
        tiesField.setEditable(false); // Make it non-editable

        // Add labels and text fields to the panel
        add(playerWinsLabel);
        add(playerWinsField);
        add(computerWinsLabel);
        add(computerWinsField);
        add(tiesLabel);
        add(tiesField);

        // Initialize counts to 0
        playerWins = 0;
        computerWins = 0;
        ties = 0;

        // Update text fields with initial counts
        updateCounts(playerWins, computerWins, ties);
    }

    // Method to update the counts in the text fields
    public void updateCounts(int playerWins, int computerWins, int ties) {
        playerWinsField.setText(String.valueOf(playerWins));
        computerWinsField.setText(String.valueOf(computerWins));
        tiesField.setText(String.valueOf(ties));
    }

    // Method to increment player wins count
    public void incrementPlayerWins() {
        playerWins++;
        updateCounts(playerWins, computerWins, ties);
    }

    // Method to increment computer wins count
    public void incrementComputerWins() {
        computerWins++;
        updateCounts(playerWins, computerWins, ties);
    }

    // Method to increment ties count
    public void incrementTies() {
        ties++;
        updateCounts(playerWins, computerWins, ties);
    }

    // Getters for counts
    public int getPlayerWins() {
        return playerWins;
    }

    public int getComputerWins() {
        return computerWins;
    }

    public int getTies() {
        return ties;
    }
}