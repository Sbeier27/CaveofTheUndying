package Control.GameController;

import Control.Strings.Endings.EndingHandler;
import Control.Player.Player;
import Control.Strings.RoomDescriptions.DescriptionHandler;
import Control.Strings.Rooms.RoomHandler;
import Display.StartScreen;

public class GameController {
    private Player currentPlayer = Player.getPlayerInstance(); // Controls our Player
    private static GameController gameController = new GameController();
        public static GameController getInstance(){return gameController;}




    public void Play(){ // This will control our game loop
        EndingHandler endingHandler = EndingHandler.getEndingHandler();
                endingHandler.initializeEndingList();
        DescriptionHandler descriptionHandler = DescriptionHandler.getDescriptionHandler();
                descriptionHandler.initializeDescriptionList();
        RoomHandler roomHandler = RoomHandler.getInstance();
                roomHandler.initializeRoomHandler();
        StartScreen startScreen = StartScreen.getStartScreen();
        startScreen.initiateStartScreen();
    }
}
