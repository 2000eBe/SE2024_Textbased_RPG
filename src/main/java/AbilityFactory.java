import java.util.ArrayList;
import java.util.List;

// Diese Klasse ist verantwortlich für das Erstellen und Verwalten von Fähigkeiten
public class AbilityFactory {
    // Fähigkeiten für Magier
    private static final List<Ability> MAGICIAN_ABILITIES = new ArrayList<>();
    // Fähigkeiten für Krieger
    private static final List<Ability> WARRIOR_ABILITIES = new ArrayList<>();

    static {
        // Fähigkeiten für Magier
        MAGICIAN_ABILITIES.add(new Ability("Feuerball", "Ein mächtiger Feuerzauber.", 1));
        MAGICIAN_ABILITIES.add(new Ability("Heilaura", "Ein Zauber, der um 40 HP heilt.", 2));
        MAGICIAN_ABILITIES.add(new Ability("Schwächender Fluch", "Ein Fluch, der die Feinde schwächt.", 3));
        MAGICIAN_ABILITIES.add(new Ability("Feuerschwall", "Eine mächtige Feuerattacke, die alle Feinde trifft.", 4));
        MAGICIAN_ABILITIES.add(new Ability("Meteor", "Beschwört einen Meteor, der enormen Schaden verursacht.", 5));

        // Fähigkeiten für Krieger
        WARRIOR_ABILITIES.add(new Ability("Zerschmetternder Hieb", "Ein mächtiger Schlag, der großen Schaden verursacht.", 1));
        WARRIOR_ABILITIES.add(new Ability("Schildaura", "Errichtet eine magische Barriere um den Krieger.", 2));
        WARRIOR_ABILITIES.add(new Ability("Wirbelschlag", "Eine schnelle Angriffskombination, die mehrere Ziele trifft.", 3));
        WARRIOR_ABILITIES.add(new Ability("Schlachtruf", "Schüchtert Gegner ein und reduziert deren Defensivität.", 4));
        WARRIOR_ABILITIES.add(new Ability("Hinrichten", "Wenn der Gegner weniger als 30% HP hat, beendest du es schnell und kaltblütig (Über 30% HP ist es ein sehr mächtiger Hieb!)!", 5));
    }

    // Methode, um die verfügbaren Fähigkeiten für einen bestimmten Spieler abzurufen
    public static List<Ability> getAvailableAbilities(CharacterClasses characterClass, int level) {
        if (characterClass == CharacterClasses.MAGIER) {
            return getAbilitiesByLevel(MAGICIAN_ABILITIES, level);
        } else {
            return getAbilitiesByLevel(WARRIOR_ABILITIES, level);
        }
    }

    // Hilfsmethode, um Fähigkeiten nach Level zu filtern
    private static List<Ability> getAbilitiesByLevel(List<Ability> abilities, int level) {
        List<Ability> availableAbilities = new ArrayList<>();
        for (Ability ability : abilities) {
            if (ability.getLevelRequirement() <= level) {
                availableAbilities.add(ability);
            }
        }
        return availableAbilities;
    }
}
