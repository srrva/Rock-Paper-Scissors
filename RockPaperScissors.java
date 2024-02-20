package pack;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RockPaperScissors extends JFrame implements ActionListener {

    private JButton rockButton, paperButton, scissorsButton;
    private JLabel resultLabel;

    private JTextArea resultsTextArea;
    private StatsPanel statsPanel;


    public RockPaperScissors() {
        setTitle("Rock Paper Scissors Game");
        setSize(1000, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        statsPanel = new StatsPanel();
        add(statsPanel, BorderLayout.WEST);

        JPanel mainPnl = new JPanel(new BorderLayout()); // Create main panel using BorderLayout
        JPanel buttonPnl = new JPanel(new FlowLayout());
        rockButton = new JButton("Rock");
        paperButton = new JButton("Paper");
        scissorsButton = new JButton("Scissors");
        resultLabel = new JLabel("Choose your move!");
        JButton quitBtn = new JButton("Quit");
        QuitListener listener = new QuitListener();
        quitBtn.addActionListener(listener);

        ImageIcon rockPng = new ImageIcon(System.getProperty("user.dir") + "/src/pack/rock.png");
        JLabel rockImageLabel = new JLabel(rockPng);
        ImageIcon paperPng = new ImageIcon(System.getProperty("user.dir") + "/src/pack/paper.png");
        JLabel paperImageLabel = new JLabel(paperPng);
        ImageIcon scissorsPng = new ImageIcon(System.getProperty("user.dir") + "/src/pack/scissors.png");
        JLabel scissorsImageLabel = new JLabel(scissorsPng);

        buttonPnl.add(rockImageLabel);
        buttonPnl.add(rockButton);
        buttonPnl.add(paperImageLabel);
        buttonPnl.add(paperButton);
        buttonPnl.add(scissorsImageLabel);
        buttonPnl.add(scissorsButton);
        buttonPnl.add(quitBtn);

        add(resultLabel);

        rockButton.addActionListener(this);
        paperButton.addActionListener(this);
        scissorsButton.addActionListener(this);


        mainPnl.add(buttonPnl, BorderLayout.CENTER);
        mainPnl.add(resultLabel, BorderLayout.SOUTH);
        add(mainPnl);

        resultsTextArea = new JTextArea(15, 30);
        resultsTextArea.setEditable(false); // Make text area read-only
        JScrollPane scrollPane = new JScrollPane(resultsTextArea);

        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.add(mainPnl, BorderLayout.CENTER);
        contentPanel.add(scrollPane, BorderLayout.EAST);

        Border blackBorder = BorderFactory.createLineBorder(Color.black);
        mainPnl.setBorder(blackBorder);

        add(contentPanel, BorderLayout.CENTER);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String userChoice = "";
        String computerChoice = "";
        String result = "";

        if (e.getSource() == rockButton) {
            userChoice = "Rock";
        } else if (e.getSource() == paperButton) {
            userChoice = "Paper";
        } else if (e.getSource() == scissorsButton) {
            userChoice = "Scissors";
        }

        Random random = new Random();
        int computerInt = random.nextInt(3); // 0 for Rock, 1 for Paper, 2 for Scissors

        switch (computerInt) {
            case 0:
                computerChoice = "Rock";
                break;
            case 1:
                computerChoice = "Paper";
                break;
            case 2:
                computerChoice = "Scissors";
                break;
        }

        if (userChoice.equals(computerChoice)) {
            result = "It's a tie!";
            statsPanel.incrementTies();
        } else if ((userChoice.equals("Rock") && computerChoice.equals("Scissors")) ||
                (userChoice.equals("Paper") && computerChoice.equals("Rock")) ||
                (userChoice.equals("Scissors") && computerChoice.equals("Paper"))) {
            result = "You win!";
            statsPanel.incrementPlayerWins();
        } else {
            result = "Computer wins!";
            statsPanel.incrementComputerWins();
        }

        resultLabel.setText("You chose " + userChoice + ", Computer chose " + computerChoice + ". " + result);
        String gameResult = resultLabel.getText();
        resultsTextArea.append(gameResult + "\n");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    }

