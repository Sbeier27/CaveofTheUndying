package Display.RoomDisplay;

import Control.Rooms.BasicRoomBuilder;
import Control.Rooms.PuzzleRoomBuilder;
import Control.Rooms.Room;
import Control.Rooms.RoomBuilder;
import Control.Strings.RoomDescriptions.DescriptionHandler;
import Display.EndingDisplay.Ending;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoomDisplay {
    RoomBuilder roomBuilder;
    Room room;
    public void setRoom(int roomType, RoomBuilder eastRoom, RoomBuilder westRoom, RoomBuilder northRoom, RoomBuilder southRoom, int roomDescription, String answer, String puzzle, Room previousRoom){
        DescriptionHandler descriptionHandler = DescriptionHandler.getDescriptionHandler();
        if (roomType == 0){
            roomBuilder = new BasicRoomBuilder();
        } else if (roomType == 1) {
            roomBuilder = new PuzzleRoomBuilder();
        }
        roomBuilder.setRoomVariables(descriptionHandler.getDescription(roomDescription), eastRoom, westRoom, northRoom, southRoom, answer, puzzle, previousRoom);
    }
    private JButton northButton = new JButton("N");
    private JButton southButton = new JButton("S");
    private JButton eastButton = new JButton("E");
    private JButton westButton = new JButton("W");
    int charIndex = 0;
    private JLabel startText = new JLabel("<html></html>");
    private JTextField textEntry = new JTextField(20);
    private JButton enterButton = new JButton("Enter");
    JPanel panel = new JPanel(new GridBagLayout());
    JFrame masterFrame;
    public void initializeDisplay(JFrame frame){ //Initializing the display
        String fullText = roomBuilder.getDescription().replace("\n", "<br>");
        masterFrame = frame;

        panel.setBackground(new Color(0, 0, 0)); // Set the background color to black

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add some padding between elements
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(startText, gbc);

        gbc.gridy = 1;
        panel.add(textEntry, gbc);

        gbc.gridy = 2;
        panel.add(enterButton, gbc);

        frame.add(panel);

        // Text Stuff
        startText.setForeground(Color.WHITE);
        // Remove background of textfield and button
        textEntry.setOpaque(false);
        textEntry.setBackground(new Color(0, 0, 0, 0));
        textEntry.setForeground(Color.WHITE);
        enterButton.setOpaque(false);
        enterButton.setBackground(new Color(0, 0, 0, 0));
        enterButton.setForeground(Color.WHITE);
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Uncomment the following code to enable the functionality
                checkString();
            }
        });

        // Typing effect
        addText(fullText);
        // Add directional buttons
        addDirectionalButtons(frame);
    }

    private void checkString() {
        if(roomBuilder.interact(textEntry.getText()).equals("Admin.Fight"))
        {
            // Logic for combat encounter
        }
        else if (roomBuilder.interact(textEntry.getText()).equals("you lay down to die, having lost faith in yourself")) {
            death(1);
    }
        else if (roomBuilder.interact(textEntry.getText()) != null) {
            addText(roomBuilder.interact(textEntry.getText()));
        }
    }
    private void addText(String fullText){
        charIndex = 0; // Reset charIndex
        startText.setText("<html></html>"); // Clear the text
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
    private void addDirectionalButtons(JFrame frame) {
        frame.setLayout(new BorderLayout());

        northButton.setOpaque(false);
        northButton.setBackground(new Color(0, 0, 0, 0));
        northButton.setForeground(Color.WHITE);
        northButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic for moving north
            }
        });

        southButton.setOpaque(false);
        southButton.setBackground(new Color(0, 0, 0, 0));
        southButton.setForeground(Color.WHITE);
        southButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic for moving south
            }
        });

        eastButton.setOpaque(false);
        eastButton.setBackground(new Color(0, 0, 0, 0));
        eastButton.setForeground(Color.WHITE);
        eastButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic for moving east
            }
        });

        westButton.setOpaque(false);
        westButton.setBackground(new Color(0, 0, 0, 0));
        westButton.setForeground(Color.WHITE);
        westButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic for moving west
            }
        });

        JPanel northPanel = new JPanel();
        northPanel.setOpaque(false);
        northPanel.add(northButton);

        JPanel southPanel = new JPanel();
        southPanel.setOpaque(false);
        southPanel.add(southButton);

        JPanel eastPanel = new JPanel();
        eastPanel.setOpaque(false);
        eastPanel.add(eastButton);

        JPanel westPanel = new JPanel();
        westPanel.setOpaque(false);
        westPanel.add(westButton);

        frame.add(northPanel, BorderLayout.NORTH);
        frame.add(southPanel, BorderLayout.SOUTH);
        frame.add(eastPanel, BorderLayout.EAST);
        frame.add(westPanel, BorderLayout.WEST);
    }
    private void death(int endingNumber){
        panel.setVisible(false);
        Ending ending = Ending.getEnding();
        ending.initiateEnding(masterFrame, endingNumber);
        masterFrame.revalidate();
        masterFrame.repaint();
    }
    }
