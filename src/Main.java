import Control.GameController.GameController;
import Display.StartScreen;

public class Main {
    public static void main(String[] args) {
        GameController gameController = GameController.getInstance();
        gameController.Play();
    }
}