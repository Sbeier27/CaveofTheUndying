package Control.Monsters;

import Control.Objects.GameObject;

public abstract class MonsterCombatTemplate {
    private MonsterStats monsterStats;
    private GameObject weapon;
    public final void runTurn (){
        beginTurn();
        takeAction();
        endTurn();
    }

    abstract void beginTurn();
    abstract void takeAction();
    abstract void endTurn();
    public void equipWeapon(GameObject gameObject){
        weapon = gameObject;
    }
}