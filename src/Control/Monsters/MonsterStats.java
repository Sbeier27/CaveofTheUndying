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

    //Functions
    public void takeDamage(int Damage){
        this.monsterHealth = monsterHealth - Damage;
        if(monsterHealth <= 0){
            death();
        }
    }
    public void death(){
        // Need to add the functionality
    }

    // Constructor

    public MonsterStats(MonsterType monsterType, int monsterHealth, String monsterName) {
        this.monsterType = monsterType;
        this.monsterHealth = monsterHealth;
        this.monsterName = monsterName;
    }
}