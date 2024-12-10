package Control.Strings.Rooms;

import Control.Rooms.BasicRoomBuilder;
import Control.Rooms.PuzzleRoomBuilder;
import Control.Rooms.RoomBuilder;
import Control.Strings.RoomDescriptions.DescriptionHandler;

import java.util.ArrayList;
import java.util.List;

public class RoomHandler {
    private static RoomHandler roomHandler = new RoomHandler();
        public static RoomHandler getInstance(){return roomHandler;}

    private List <RoomBuilder> roomBuilderList = new ArrayList<>();
        public RoomBuilder getRoom(int roomNumber){return roomBuilderList.get(roomNumber);}
    public void initializeRoomHandler(){
        DescriptionHandler descriptionHandler = DescriptionHandler.getDescriptionHandler();
            RoomBuilder startRoom = new BasicRoomBuilder();
            RoomBuilder basicRoom0 = new BasicRoomBuilder();
            RoomBuilder enemyRoom0 = new BasicRoomBuilder();
            RoomBuilder itemRoom0 = new BasicRoomBuilder();
            RoomBuilder enemyRoom1 = new BasicRoomBuilder();
            RoomBuilder puzzleRoom0 = new PuzzleRoomBuilder();
            RoomBuilder basicRoom1 = new BasicRoomBuilder();
            RoomBuilder enemyRoom2 = new BasicRoomBuilder();
            RoomBuilder puzzleRoom1 = new PuzzleRoomBuilder();
            RoomBuilder enemyRoom3 = new BasicRoomBuilder();

                startRoom.setRoomVariables(descriptionHandler.getDescription(0), basicRoom0, null, null, null, "Pray", null, null);
                basicRoom0.setRoomVariables(descriptionHandler.getDescription(1), null, null, itemRoom0, enemyRoom0, "Bleed you Hand", null, null);
                enemyRoom0.setRoomVariables(descriptionHandler.getDescription(1), null, null, basicRoom0, null, "Attack", null, null );
                itemRoom0.setRoomVariables(descriptionHandler.getDescription(1), null, null, enemyRoom1, basicRoom0, "Pick Up", null, null);
                enemyRoom1.setRoomVariables(descriptionHandler.getDescription(1), null, null, puzzleRoom0, itemRoom0, "Attack", null, null );
                puzzleRoom0.setRoomVariables(descriptionHandler.getDescription(1), basicRoom1, null, null, enemyRoom1, "Placeholder", "Placeholder", null );
                basicRoom1.setRoomVariables(descriptionHandler.getDescription(1), enemyRoom2, puzzleRoom0, null, null, "Light Your torch", null, null);
                enemyRoom2.setRoomVariables(descriptionHandler.getDescription(1), puzzleRoom1, basicRoom1, null, null, "Attack", null, null);
                puzzleRoom1.setRoomVariables(descriptionHandler.getDescription(1), null, enemyRoom2, null, enemyRoom3, "Placeholder", "Placeholder", null);
    }
}
