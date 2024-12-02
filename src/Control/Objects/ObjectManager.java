package Control.Objects;


import java.util.HashMap;

public class ObjectManager {
    // A List of all the objects in the game that anything can call to retrieve an object
    private HashMap <String, GameObject> objectList = new HashMap<>();
    private static ObjectManager objectManager = new ObjectManager();
    public static ObjectManager getObjectManager(){
        return objectManager;
    }

    public void initializeObjectList() {
        objectList.put("Broken Sword", new GameObject(ObjectType.Weapon, 1, false));
        objectList.put("Ghoul Claws", new GameObject(ObjectType.Weapon, 1, false));
        objectList.put("Broken Shield", new GameObject(ObjectType.Shield, 1, false));
        objectList.put("Longsword", new GameObject(ObjectType.Weapon, 2, false));
        objectList.put("Heater Shield", new GameObject(ObjectType.Shield, 2, false));
        objectList.put("Torch", new GameObject(ObjectType.Shield, 0, true));
        objectList.put("Engraved Torch", new GameObject(ObjectType.Shield, 1, true));
        objectList.put("Hero Sword", new GameObject(ObjectType.Weapon, 3, true));
        objectList.put("Hero Shield", new GameObject(ObjectType.Shield, 3, true));
        objectList.put("Phoenix Talons", new GameObject(ObjectType.Weapon, 5, true));
    }
    public GameObject getObject(String objectName){
        return objectList.get(objectName);
    }
}
