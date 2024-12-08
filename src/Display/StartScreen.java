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
    private JLabel startText = new JLabel("You find yourself at the entrance to a large cavern");
    private JTextField startButton = new JTextField(20);
    private JButton inputButton = new JButton("Enter");

    public void initiateStartScreen(){
        frame.setSize(1300,1500);
        frame.setTitle("Cave of the Undying");
        frame.setVisible(true);
        frame.setIconImage(icon.getImage());
            System.out.println(icon); // Testing

        JPanel panel = new JPanel(new GridBagLayout());
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

        // Add action listener to the button
        inputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Uncomment the following code to enable the functionality

                if (startButton.getText().equals("Enter The Cave")) {
                    frame.setVisible(false);
                }

            }
        });
    }
}
