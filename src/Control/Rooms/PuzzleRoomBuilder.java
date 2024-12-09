package Control.Rooms;

public class PuzzleRoomBuilder implements RoomBuilder{

    private Room room;
    private String interaction;
    private String description;
    private RoomBuilder eastern;
    private RoomBuilder western;
    private RoomBuilder northern;
    private RoomBuilder southern;

    public PuzzleRoomBuilder(){
        this.room = new Room();
    }

    //the basic interaction system
    @Override
    public String interact(){
        room.setCommand(interaction);
        if(interaction.equalsIgnoreCase("Interact")){
            return room.description;
        }else if(interaction.equalsIgnoreCase("Attack")){
            return "there is nothing to attack...you waste your strength";
        }else if(interaction.equalsIgnoreCase("Give up")) {
            return "you lay down to die, having lost faith in yourself";
        return null;
    }

    /* These commands are supposed to load the room to the proper direction if there is one
     * and if there isn't a room in that direction display an appropriate message */

    @Override
    public void east(){
        eastern;
    }
    @Override
    public void west(){
        western;
    }
    @Override
    public void north(){
        northern;
    }
    @Override
    public void south(){
        southern;
    }

    @Override
    public RoomBuilder getRoom() {
        return null;
    }
}
