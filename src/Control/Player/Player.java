package Control.Player;

import Control.Observer.Observer;
import Control.Observer.GameNotifier;
import Control.Objects.GameObject;
import Control.Monsters.MonsterCombatTemplate;

import java.util.ArrayList;
import java.util.List;

public class Player implements GameNotifier {
    private int health;
    private int score;
    private List<Observer> observers;
    private static Player playerInstance = new Player(3);
    private GameObject equippedWeapon;

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

    public void dealDamageToMonster(MonsterCombatTemplate monster) {
        int damage = equippedWeapon != null ? equippedWeapon.getObjectStat() : 1; // Default damage is 1 if no weapon is equipped
        monster.getMonsterStats().takeDamage(damage);
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

    public static Player getPlayerInstance() {
        return playerInstance;
    }

    public void equipWeapon(GameObject weapon) {
        this.equippedWeapon = weapon;
    }

    public GameObject getEquippedWeapon() {
        return equippedWeapon;
    }
}
