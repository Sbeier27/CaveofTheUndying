package Control.Monsters;

import Control.Objects.GameObject;
import Control.Objects.ObjectManager;


public class Monster_Skeleton extends MonsterCombatTemplate {
    private MonsterStats monsterStats = new MonsterStats(MonsterType.Skeleton, 1, "Skeleton");
    private ObjectManager objectManager = ObjectManager.getObjectManager();
    private GameObject weapon = objectManager.getObject("Broken Sword");
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