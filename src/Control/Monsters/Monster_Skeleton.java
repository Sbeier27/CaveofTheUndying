package Control.Monsters;

import Control.Objects.GameObject;
import Control.Objects.ObjectManager;
import Control.Player.Player;

public class Monster_Skeleton extends MonsterCombatTemplate {
    private ObjectManager objectManager = ObjectManager.getObjectManager();
    private GameObject weapon = objectManager.getObject("Broken Sword");

    public Monster_Skeleton() {
        this.monsterStats = new MonsterStats(MonsterType.Skeleton, 1, "Skeleton");
        equipWeapon(weapon);
    }

    @Override
    void beginTurn(Player player) {
        System.out.println("Skeleton begins its turn.");
    }

    @Override
    void takeAction(Player player) {
        // Monster deals damage to the player during its action
        player.takeDamage(weapon.getObjectStat());
    }

    @Override
    void endTurn() {
        System.out.println("Skeleton's turn ends.");
    }
}
