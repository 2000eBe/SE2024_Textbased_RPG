import java.util.Collection;
import java.util.List;

// This class should visualize the map of areas or dungeon rooms with the symbols - and |
public class Map {

    private final String description;

    private final boolean isBossArea;
    private List<Monster> monsters;

    private final boolean hasSecretChest;
    public Map(String description, List<Monster> monsters, boolean isBossArea, boolean hasSecretChest) {
        this.description = description;
        this.monsters = monsters;
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

    public List<Monster> getMonster() {
        return monsters;
    }

    public boolean isBossArea() {
        return isBossArea;
    }

    public boolean itHasSecretChest() {
        return hasSecretChest;
    }

    public Map getLevel(int currentLevel) {
        return null;
    }

    public Collection<Object> getLevels() {
        return null;
    }
}
