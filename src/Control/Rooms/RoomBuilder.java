package Control.Rooms;

public interface RoomBuilder {

    String interact();
    void east();
    void west();
    void north();
    void south();
    RoomBuilder getRoom();

}