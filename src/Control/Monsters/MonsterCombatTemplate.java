package Control.Monsters;

import Control.Objects.GameObject;
import Control.Player.Player;

public abstract class MonsterCombatTemplate {
    protected MonsterStats monsterStats;
    protected GameObject weapon;

    public final void runTurn(Player player) {
        beginTurn();
        takeAction(player);
        endTurn();
    }

    abstract void beginTurn();
    abstract void takeAction(Player player);
    abstract void endTurn();

    public void equipWeapon(GameObject gameObject) {
        weapon = gameObject;
    }

    public MonsterStats getMonsterStats() {
        return monsterStats;
    }
}
