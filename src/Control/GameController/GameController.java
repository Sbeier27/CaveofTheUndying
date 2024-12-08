package Control.GameController;

import Control.Player.Player;
import Display.StartScreen;

public class GameController {
    private Player currentPlayer = Player.getPlayerInstance(); // Controls our Player
    private static GameController gameController = new GameController();
        public static GameController getInstance(){return gameController;}




    public void Play(){ // This will control our game loop
        StartScreen startScreen = StartScreen.getStartScreen();
        startScreen.initiateStartScreen();
    }
}
