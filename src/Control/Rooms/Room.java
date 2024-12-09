package Control.Rooms;

public class Room {

    private String command;
    String description;
    private Room nextRoom;
    private Room prevRoom;

    public void setCommand(String command) {
        this.command = command;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String description() {return description;}

    public void setNextRoom(Room nextRoom) {
        this.nextRoom = nextRoom;
    }

    public void setPrevRoom(Room prevRoom) {
        this.prevRoom = prevRoom;
    }
}
