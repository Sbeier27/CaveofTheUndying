package Control.Score;

import Control.Observer.Observer;

public class Score implements Observer {
    private int currentScore;

    @Override
    public void update(int health, int score) {
        this.currentScore = score;
        displayStats();
    }

    public void displayStats() {
        // TO BE IMPLEMENTED
    }
}
