package Control.Monsters;

import Control.Objects.GameObject;
import Control.Objects.ObjectManager;

public class Monster_FinalBoss extends MonsterCombatTemplate{
    private MonsterStats monsterStats = new MonsterStats(MonsterType.ChainedPhoenix, 5, "The Chained Deity");
    private ObjectManager objectManager = ObjectManager.getObjectManager();
    private GameObject weapon = objectManager.getObject("Phoenix Talons");
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
