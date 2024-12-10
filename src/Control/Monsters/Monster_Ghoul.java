package Control.Monsters;

import Control.Objects.GameObject;
import Control.Objects.ObjectManager;
import Control.Player.Player;

public class Monster_Ghoul extends MonsterCombatTemplate {
    private ObjectManager objectManager = ObjectManager.getObjectManager();
    private GameObject weapon = objectManager.getObject("Ghoul Claws");

    public Monster_Ghoul() {
        this.monsterStats = new MonsterStats(MonsterType.Ghoul, 3, "Ghoul");
        equipWeapon(weapon);
    }

    @Override
    void beginTurn() {
        System.out.println("Ghoul begins its turn.");
    }

    @Override
    void takeAction(Player player) {
        // Monster deals damage to the player during its action
        player.takeDamage(weapon.getObjectStat());
    }

    @Override
    void endTurn() {
        System.out.println("Ghoul's turn ends.");
    }
}
