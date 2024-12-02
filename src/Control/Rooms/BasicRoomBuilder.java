package Control.Rooms;

public class BasicRoomBuilder implements RoomBuilder{

    private Room room;
    private String interaction;

    public BasicRoomBuilder(){
        this.room = new Room();
    }

    @Override
    public String interact(){
        room.setCommand(interaction);
        if(interaction.equalsIgnoreCase("Interact")){
            return interaction;
        }else if(interaction.equalsIgnoreCase("Att")){
            return interaction;
        }
        return null;
    }

    @Override
    public void east(){

    }
    @Override
    public void west(){

    }
    @Override
    public void north(){

    }
    @Override
    public void south(){

    }

    @Override
    public RoomBuilder getRoom() {

        return null;
    }
}
