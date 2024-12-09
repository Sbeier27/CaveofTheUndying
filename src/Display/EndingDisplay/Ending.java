package Display.EndingDisplay;

import Control.Strings.Endings.EndingHandler;
import Display.StartScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ending {
    private Image backgroundImage = new ImageIcon("Images/FrameBackground.PNG").getImage();
    private static Ending ending = new Ending();
            public static Ending getEnding() { return ending; }
    int charIndex = 0;
    private JLabel startText = new JLabel("<html></html>");
    private JTextField startButton = new JTextField(20);
    private JButton inputButton = new JButton("Enter");
    JPanel panel = new JPanel(new GridBagLayout());
    JFrame masterFrame;

    public void initiateEnding(JFrame gameFrame, int endingNumber) {
        masterFrame = gameFrame;
        EndingHandler endingHandler = EndingHandler.getEndingHandler();
        String fullText = endingHandler.getEnding(endingNumber).replace("\n", "<br>");

        panel.setBackground(new Color(0, 0, 0)); // Set the background color to black

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add some padding between elements
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(startText, gbc);

        gbc.gridy = 1;
        panel.add(startButton, gbc);

        gbc.gridy = 2;
        panel.add(inputButton, gbc);

        gameFrame.add(panel);

        // Text Stuff
        startText.setForeground(Color.WHITE);
        // Remove background of textfield and button
        startButton.setOpaque(false);
        startButton.setBackground(new Color(0, 0, 0, 0));
        startButton.setForeground(Color.WHITE);
        inputButton.setOpaque(false);
        inputButton.setBackground(new Color(0, 0, 0, 0));
        inputButton.setForeground(Color.WHITE);
        inputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Uncomment the following code to enable the functionality
                checkString();
            }
        });
        // Typing effect
        Timer timer = new Timer(80, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (charIndex < fullText.length()) {
                    String currentText = startText.getText();
                    currentText = currentText.substring(0, currentText.length() - 7); // Remove the closing </html>
                    startText.setText(currentText + fullText.charAt(charIndex) + "</html>");
                    charIndex++;
                } else {
                    ((Timer) e.getSource()).stop();
                }
            }
        });
        timer.setInitialDelay(0);
        timer.start();
    }

    private void checkString(){
        if (startButton.getText().equalsIgnoreCase("Restart") || startButton.getText().equalsIgnoreCase("Try Again") || startButton.getText().equalsIgnoreCase("Return To The Cave") || startButton.getText().equalsIgnoreCase("The World Has Ended")){
            restartGame();
        } else if (startButton.getText().equalsIgnoreCase("End")) {
            endGame();
        }
    }
    private void restartGame(){
        panel.setVisible(false);
        StartScreen startScreen = StartScreen.getStartScreen();
        startScreen.initiateStartScreen();
        masterFrame.revalidate();
        masterFrame.repaint();
    }
    private void endGame(){
        masterFrame.setVisible(false);
    }
}
