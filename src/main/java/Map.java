import java.util.Collection;
import java.util.List;

// This class should visualize the map of areas
public class Map {

    private final String description;

    private final boolean isBossArea;
    private final List<Monster> monsters;


    public Map(String description, List<Monster> monsters, boolean isBossArea) {
        this.description = description;
        this.monsters = monsters;
        this.isBossArea = isBossArea;
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
}
