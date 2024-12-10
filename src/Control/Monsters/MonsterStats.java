package Control.Monsters;

import java.awt.*;

public class MonsterStats {
    // Holds Monster's Stats and handles death and damage
    private MonsterType monsterType;
    private int monsterHealth;
    // Monster Name is the name that will be displayed by the Swing Program
    private String monsterName;
    //
    private Image monsterSprite;

    // Functions
    public void takeDamage(int damage) {
        this.monsterHealth -= damage;
        if (monsterHealth <= 0) {
            death();
        }
    }

    public void death() {
        System.out.println(monsterName + " has been defeated!");
        // Add functionality if needed
    }

    // Constructor
    public MonsterStats(MonsterType monsterType, int monsterHealth, String monsterName) {
        this.monsterType = monsterType;
        this.monsterHealth = monsterHealth;
        this.monsterName = monsterName;
    }

    // Getters
    public MonsterType getMonsterType() {
        return monsterType;
    }

    public int getMonsterHealth() {
        return monsterHealth;
    }

    public String getMonsterName() {
        return monsterName;
    }
}
