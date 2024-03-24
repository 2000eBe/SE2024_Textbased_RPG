import java.util.Collection;

// This class should visualize the map of areas or dungeon rooms with the symbols - and |
public class Map {

    private final String description;
    private final Monster monster;
    private final int numOfMonster;
    private final boolean isBossArea;

    private final boolean hasSecretChest;
    public Map(String description, Monster monster, int numOfMonster, boolean isBossArea, boolean hasSecretChest) {
        this.description = description;
        this.monster = monster;
        this.numOfMonster = numOfMonster;
        this.isBossArea = isBossArea;
        this.hasSecretChest = hasSecretChest;
    }

    public static Map newMapInstance(){
        String description = null;
        int numOfMonsters = 0;
        boolean isBossArea = false;
        boolean hasSecretVendor = false;
        int random = Main.rand.nextInt(3) + 1;
        return null;  //new Map(description,Monster.randomMonster(), 2, false, false);
    }

    // Getter Methods

    public String getDescription() {
        return description;
    }

    public Monster getMonster() {
        return monster;
    }

    public int getNumOfMonster() {
        return numOfMonster;
    }

    public boolean isBossArea() {
        return isBossArea;
    }

    public boolean isHasSecretChest() {
        return hasSecretChest;
    }

    public Map getLevel(int currentLevel) {
        return null;
    }

    public Collection<Object> getLevels() {
        return null;
    }
}
