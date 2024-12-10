package Display.RoomDisplay;

import Control.Rooms.BasicRoomBuilder;
import Control.Rooms.PuzzleRoomBuilder;
import Control.Rooms.Room;
import Control.Rooms.RoomBuilder;
import Control.Strings.Rooms.RoomHandler;
import Display.EndingDisplay.Ending;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoomDisplay {
    RoomBuilder roomBuilder;
    Room room;
    public void setRoomWithInt(int roomNumber) {
        RoomHandler roomHandler = RoomHandler.getInstance();
        roomBuilder = roomHandler.getRoom(roomNumber);
    }

    public void setRoomWithRoom(RoomBuilder room) {
        roomBuilder = room;
    }
    private JButton northButton = new JButton("N");
        JPanel northPanel = new JPanel();
    private JButton southButton = new JButton("S");
        JPanel southPanel = new JPanel();
    private JButton eastButton = new JButton("E");
        JPanel eastPanel = new JPanel();
    private JButton westButton = new JButton("W");
        JPanel westPanel = new JPanel();
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
            addText(roomBuilder.interact(textEntry.getText()));
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
        northButton.setOpaque(false);
        northButton.setBackground(new Color(0, 0, 0, 0));
        northButton.setForeground(Color.WHITE);
        northButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(roomBuilder.north() == null){
                    addText("You take a break and stare at a wall\nThe wall is quite boring");
                }
                else {
                    switchRooms(roomBuilder.north());
                }
            }
        });

        southButton.setOpaque(false);
        southButton.setBackground(new Color(0, 0, 0, 0));
        southButton.setForeground(Color.WHITE);
        southButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(roomBuilder.south() == null){
                    addText("You take a break and stare at a wall\nThe wall is quite boring");
                }
                else {
                    switchRooms(roomBuilder.south());
                }
            }
        });

        eastButton.setOpaque(false);
        eastButton.setBackground(new Color(0, 0, 0, 0));
        eastButton.setForeground(Color.WHITE);
        eastButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(roomBuilder.east() == null){
                    addText("You take a break and stare at a wall\nThe wall is quite boring");
                }
                else{
                    switchRooms(roomBuilder.east());
                }
            }
        });

        westButton.setOpaque(false);
        westButton.setBackground(new Color(0, 0, 0, 0));
        westButton.setForeground(Color.WHITE);
        westButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(roomBuilder.west() == null){
                    addText("You take a break and stare at a wall\nThe wall is quite boring");
                }
                else{
                    switchRooms(roomBuilder.west());
                }
            }
        });

        northPanel.setBackground(new Color(0, 0, 0)); // Set the background color to black
        northPanel.add(northButton);

        southPanel.setBackground(new Color(0, 0, 0)); // Set the background color to black
        southPanel.add(southButton);

        eastPanel.setBackground(new Color(0, 0, 0)); // Set the background color to black
        eastPanel.add(eastButton);

        westPanel.setBackground(new Color(0, 0, 0)); // Set the background color to black
        westPanel.add(westButton);

        frame.add(northPanel, BorderLayout.NORTH);
        frame.add(southPanel, BorderLayout.SOUTH);
        frame.add(eastPanel, BorderLayout.EAST);
        frame.add(westPanel, BorderLayout.WEST);
    }
    private void removeDirectionalButtons(JFrame frame) {
        frame.remove(northPanel);
        frame.remove(southPanel);
        frame.remove(eastPanel);
        frame.remove(westPanel);
        frame.revalidate();
        frame.repaint();
    }
    private void death(int endingNumber){
        panel.setVisible(false);
        removeDirectionalButtons(masterFrame);
        Ending ending = Ending.getEnding();
        ending.initiateEnding(masterFrame, endingNumber);

        masterFrame.revalidate();
        masterFrame.repaint();
    }
    private void switchRooms(RoomBuilder newRoom){
        RoomDisplay roomDisplay = new RoomDisplay();
            roomDisplay.setRoomWithRoom(newRoom);
        removeDirectionalButtons(masterFrame);
        panel.setVisible(false);

        roomDisplay.initializeDisplay(masterFrame);
        masterFrame.revalidate();
        masterFrame.repaint();
    }
    }
