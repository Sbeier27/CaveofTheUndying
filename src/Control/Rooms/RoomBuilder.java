package Control.Rooms;

public interface RoomBuilder {

    String interact(String interaction);
    void east();
    void west();
    void north();
    void south();
    RoomBuilder getRoom();
    void setRoomVariables(String description, RoomBuilder eastern, RoomBuilder western, RoomBuilder northern, RoomBuilder southern, String answer, String puzzle, Room previousRoom);
    String getDescription();
}