package Display;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartScreen {
    JFrame frame = new JFrame(); // Making a new screen
    ImageIcon icon = new ImageIcon("Images/UndyingIcon.PNG");
    private Image backgroundImage = new ImageIcon("Images/FrameBackground.PNG").getImage();

    private static StartScreen startScreen = new StartScreen();
            public static StartScreen getStartScreen() {return startScreen;}
    private JLabel startText = new JLabel("");
    private JTextField startButton = new JTextField(20);
    private JButton inputButton = new JButton("Enter");
    private String fullText = "You find yourself at the entrance to a large cavern";
    private int charIndex = 0;
    JPanel panel = new JPanel(new GridBagLayout());

    public void enterTheCave(){
        panel.setVisible(false);
        // Some function from the rooms that requires the frame
        frame.revalidate();
        frame.repaint();
    }
    public void initiateStartScreen(){
        frame.setSize(1300,1500);
        frame.setTitle("Cave of the Undying");
        frame.setIconImage(icon.getImage());
        System.out.println(icon); // Testing
        frame.setVisible(true);
        frame.revalidate();
        frame.repaint();




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

        frame.add(panel);

        // Text Stuff
        startText.setForeground(Color.WHITE);
        // Remove background of textfield and button
        startButton.setOpaque(false);
        startButton.setBackground(new Color(0, 0, 0, 0));
        startButton.setForeground(Color.WHITE);
        inputButton.setOpaque(false);
        inputButton.setBackground(new Color(0, 0, 0, 0));
        inputButton.setForeground(Color.WHITE);

        // Add action listener to the button
        inputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Uncomment the following code to enable the functionality

                if (startButton.getText().equals("Enter The Cave")) {
                    enterTheCave();
                }

            }
        });
        // Typing effect
        Timer timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (charIndex < fullText.length()) {
                    startText.setText(startText.getText() + fullText.charAt(charIndex));
                    charIndex++;
                } else {
                    ((Timer) e.getSource()).stop();
                }
            }
        });
        timer.setInitialDelay(0);
        timer.start();
    }
}
