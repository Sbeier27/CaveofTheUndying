package Control.Rooms;

public class BasicRoomBuilder implements RoomBuilder{

    private Room room;
    private String interaction;
    private String description;
    private int roomNumber;
    private RoomBuilder eastern;
    private RoomBuilder western;
    private RoomBuilder northern;
    private RoomBuilder southern;
    private String puzzle;
    private String answer;
    private boolean solved = false;

    public BasicRoomBuilder(){
        this.room = new Room();
    }
    public void setRoomVariables(String description, RoomBuilder eastern, RoomBuilder western, RoomBuilder northern, RoomBuilder southern, String answer, String puzzle, Room previousRoom){
        this.description = description;
        this.eastern = eastern;
        this.western = western;
        this.northern = northern;
        this.southern = southern;
        this.answer = answer;
        this.puzzle = puzzle;
        room.setPrevRoom(previousRoom);
    }

    //the basic interaction system
    @Override
    public String interact(String interaction){
        room.setCommand(interaction);
        if(interaction.equalsIgnoreCase("Interact")){
            return room.description;

        }else if(interaction.equalsIgnoreCase("Attack")){
            return "there is nothing to attack...you waste your strength";
        }else if(interaction.equalsIgnoreCase("Give up")) {
            return "you lay down to die, having lost faith in yourself";
        } else if(interaction.equalsIgnoreCase("Examine")){
            return puzzle;
        } else if(interaction.equalsIgnoreCase(answer)){
            solved = true;
            if (answer.equalsIgnoreCase("Attack")){
                return "Admin.Fight";
            }
            else {return "you've solved the puzzle...somehow...continue";}
        }
        return "Nothing Happened";
    }

    /* These commands are supposed to load the room to the proper direction if there is one
     and if there isn't a room in that direction display an appropriate message */

    @Override
    public RoomBuilder east(){
        return eastern;
    }
    @Override
    public RoomBuilder west(){
        return western;
    }
    @Override
    public RoomBuilder north(){
        return northern;
    }
    @Override
    public RoomBuilder south(){
        return southern;
    }

    @Override
    public RoomBuilder getRoom() {
        return null;
    }
    @Override
    public String getDescription() {
        return description;
    }
    @Override
    public int getRoomNumber(){
        return roomNumber;
    }
    @Override
    public void setRoomNumber(int roomNumber){
        this.roomNumber = roomNumber;
    }
}
