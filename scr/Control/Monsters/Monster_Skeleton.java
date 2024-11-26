package Control.Monsters;

import Control.Objects.Object;
import Control.Objects.ObjectType;

public class Monster_Skeleton extends MonsterCombatTemplate{
    private MonsterStats monsterStats = new MonsterStats(MonsterType.Skeleton, 1, "Withered Skeleton");
    private Object weapon = new Object(ObjectType.Weapon, 1, false);
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
