package Control.Monsters;

import Control.Objects.Object;

public abstract class MonsterCombatTemplate {
    private MonsterStats monsterStats;
    private Object weapon;
    public final void runTurn (){
        beginTurn();
        takeAction();
        endTurn();
    }

    abstract void beginTurn();
    abstract void takeAction();
    abstract void endTurn();
    public void equipWeapon(Object object){
        weapon = object;
    }
}
