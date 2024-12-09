import Control.GameController.GameController;


public class Main {
    public static void main(String[] args) {
        GameController gameController = GameController.getInstance();
        gameController.Play();
    }
}