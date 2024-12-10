package Control.Rooms;

public interface RoomBuilder {

    String interact(String interaction);
    RoomBuilder east();
    RoomBuilder west();
    RoomBuilder north();
    RoomBuilder south();
    RoomBuilder getRoom();
    void setRoomVariables(String description, RoomBuilder eastern, RoomBuilder western, RoomBuilder northern, RoomBuilder southern, String answer, String puzzle, Room previousRoom);
    String getDescription();
    int getRoomNumber();

    void setRoomNumber(int roomNumber);
}