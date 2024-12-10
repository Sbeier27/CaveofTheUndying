package Control.Monsters;

import Control.Objects.GameObject;
import Control.Objects.ObjectManager;
import Control.Player.Player;

public class Monster_FinalBoss extends MonsterCombatTemplate {
    private ObjectManager objectManager = ObjectManager.getObjectManager();
    private GameObject weapon = objectManager.getObject("Phoenix Talons");

    public Monster_FinalBoss() {
        this.monsterStats = new MonsterStats(MonsterType.ChainedPhoenix, 5, "The Chained Deity");
        equipWeapon(weapon);
    }

    @Override
    void beginTurn(Player player) {
        System.out.println("The Chained Deity begins its turn.");
    }

    @Override
    void takeAction(Player player) {
        // Monster deals damage to the player during its action
        player.takeDamage(weapon.getObjectStat());
    }

    @Override
    void endTurn() {
        System.out.println("The Chained Deity's turn ends.");
    }
}
