package Control.Monsters;

import Control.Objects.Object;
import Control.Objects.ObjectType;

public class Monster_FinalBoss extends MonsterCombatTemplate{
    private MonsterStats monsterStats = new MonsterStats(MonsterType.ChainedPhoenix, 5, "The Chained Deity");
    private Object weapon = new Object(ObjectType.Weapon, 3, true);
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
