package Control.Player;

import Control.Observer.Observer;
import Control.Observer.GameNotifier;

import java.util.ArrayList;
import java.util.List;

public class Player implements GameNotifier {
    private int health;
    private int score;
    private List<Observer> observers;

    public Player(int health) {
        this.health = health;
        this.score = 0;
        this.observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(health, score);
        }
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) health = 0;
        notifyObservers();
    }

    public void dealDamageToMonster(String monsterType) {
        // TO BE IMPLEMENTED
        notifyObservers();
    }

    public void gainScore(int points) {
        score += points;
        notifyObservers();
    }

    public int getHealth() {
        return health;
    }

    public int getScore() {
        return score;
    }
}
