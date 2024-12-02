package Control.Objects;

public class Object {
    private ObjectType objectType;
    // Could be damage or block
    private int objectStat;
    // Will be used in some occasions
    private boolean glowing;

    // Functions
    public ObjectType getObjectType(){
        return objectType;
    }
    public int getObjectStat() {
        return objectStat;
    }
    public boolean isGlowing() {
        return glowing;
    }
    // Constructor
    public Object(ObjectType objectType, int objectStat, boolean glowing) {
        this.objectType = objectType;
        this.objectStat = objectStat;
        this.glowing = glowing;
    }
}