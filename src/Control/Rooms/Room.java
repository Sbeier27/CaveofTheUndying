package Control.Rooms;

public class Room {

    private String command;
    private String description;
    private Room nextRoom;

    public void setCommand(String command) {
        this.command = command;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNextRoom(Room nextRoom) {
        this.nextRoom = nextRoom;
    }
}
