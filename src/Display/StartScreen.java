package Display;

import javax.swing.*;
import java.awt.*;

public class StartScreen {
    JFrame frame = new JFrame(); // Making a new screen
    ImageIcon icon = new ImageIcon("Images/UndyingIcon.PNG");
    private Image backgroundImage = new ImageIcon("Images/FrameBackground.PNG").getImage();

    private static StartScreen startScreen = new StartScreen();
            public static StartScreen getStartScreen() {return startScreen;}
    private JLabel startText = new JLabel("You find yourself at the entrance to a large cavern");
    private JTextField startButton = new JTextField();

    public void initiateStartScreen(){
        frame.setSize(1300,1500);
        frame.setTitle("Cave of the Undying");
        frame.setVisible(true);
        frame.setIconImage(icon.getImage());
            System.out.println(icon); // Testing

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0,0,0)); // Set the background color to blue

        frame.add(panel);



        // Text Stuff
        startText.setForeground(Color.WHITE);

        //setting frame
        frame.add(startText);
    }
}
