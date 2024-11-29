package Control.Monsters;

import Control.Objects.GameObject;
import Control.Objects.ObjectManager;


public class Monster_Ghoul extends MonsterCombatTemplate {
    private MonsterStats monsterStats = new MonsterStats(MonsterType.Ghoul, 3, "Ghoul");
    private ObjectManager objectManager = ObjectManager.getObjectManager();
    private GameObject weapon = objectManager.getObject("Ghoul Claws");
    @Override
    void beginTurn(){
        // Need to Add Functionality
    }

    @Override
    void takeAction() {
        // Need to add Functionality
    }

    @Override
    void endTurn() {
        // Need to add Functionality
    }

}
