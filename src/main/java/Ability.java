import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Collections;

// This class represents all the abilities that can be unlocked or learned by the player
public class Ability {
    private static final Map<Integer, List<String>> MAGICIAN_ABILITIES = new HashMap<>();
    private static final Map<Integer, List<String>> WARRIOR_ABILITIES = new HashMap<>();

    static {
        // Abilities for each level
        // 1
        MAGICIAN_ABILITIES.put(1, Collections.singletonList("Feuerball"));
        WARRIOR_ABILITIES.put(1, Collections.singletonList("Zerschmetternder Hieb"));
        // 2
        MAGICIAN_ABILITIES.put(2, Collections.singletonList("Heilaura"));
        WARRIOR_ABILITIES.put(2, Collections.singletonList("Schildaura"));
        // 3
        MAGICIAN_ABILITIES.put(3, Collections.singletonList("Schwächender Fluch"));
        WARRIOR_ABILITIES.put(3, Collections.singletonList("Wirbelschlag"));
        // 4
        MAGICIAN_ABILITIES.put(4, Collections.singletonList("Feuerschwall"));
        WARRIOR_ABILITIES.put(4, Collections.singletonList("Parieren & Riposte"));
        // 5
        MAGICIAN_ABILITIES.put(5, Collections.singletonList("Meteor"));
        WARRIOR_ABILITIES.put(5, Collections.singletonList("Schlachtruf"));
    }

    public static List<String> getAvailableAbilities(CharacterClasses characterClass, int level) {
        if (characterClass == CharacterClasses.MAGIER) {
            return MAGICIAN_ABILITIES.getOrDefault(level, Collections.emptyList());
        } else {
            return WARRIOR_ABILITIES.getOrDefault(level, Collections.emptyList());
        }
    }

    public static void displayAvailableAbilities(CharacterClasses characterClass, int level){
        Map<Integer, List<String>> abilities = (Map<Integer, List<String>>) getAvailableAbilities(characterClass, level);
        if (abilities.isEmpty()) {
            System.out.println("No abilities available at this level.");
        } else {
            System.out.println("Available abilities at level " + level + ":");
            int abilityNumber = 1;
            for (Map.Entry<Integer, List<String>> entry : abilities.entrySet()) {
                System.out.println("(" + abilityNumber + ") " + entry.getKey() + ": " + entry.getValue().get(0));
                abilityNumber++;
            }
            System.out.println("Choose an ability to learn (enter the number):");
        }
    }
}
