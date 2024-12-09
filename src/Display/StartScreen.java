package Display;

import Control.Rooms.BasicRoomBuilder;
import Control.Rooms.PuzzleRoomBuilder;
import Control.Rooms.RoomBuilder;
import Display.EndingDisplay.Ending;
import Display.RoomDisplay.RoomDisplay;

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

    public void enterTheCave(){ // Activates if the player chooses to enter
        panel.setVisible(false);
        RoomBuilder roomBuilderN = new PuzzleRoomBuilder();
        RoomBuilder roomBuilderS = new BasicRoomBuilder();
        RoomDisplay roomDisplay = new RoomDisplay();
        roomDisplay.setRoom(0, null, null, roomBuilderN, roomBuilderS, 0, "Sit in the Light", null, null);
        roomDisplay.initializeDisplay(frame);
        frame.revalidate();
        frame.repaint();
    }
    public void leaveTheCave(){ // Activates if the player chooses to leave the cave
        panel.setVisible(false);
        Ending ending = Ending.getEnding();
        ending.initiateEnding(frame, 0);
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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




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
                checkString();
            }
        });
        // Typing effect
        Timer timer = new Timer(80, new ActionListener() {
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
    private void checkString(){ //Handles The strings
        if (startButton.getText().equalsIgnoreCase("Enter The Cave") || startButton.getText().equals("Enter The Cavern") || startButton.getText().equals("Walk In")){
            enterTheCave();
        } else if (startButton.getText().equalsIgnoreCase("Turn Around") || startButton.getText().equals("Leave") || startButton.getText().equals("Walk Away")) {
            leaveTheCave();
        }
    }
}
