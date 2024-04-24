import java.util.ArrayList;
import java.util.List;

public class Dungeon {

    private List<Map> levels;
    private int INITIAL_EXP = 100;
    private int currentLevelIndex;

    public Dungeon(){
        levels = new ArrayList<>();
        initializeLevels();
        currentLevelIndex = 0;

    }
//TODO LEVEL AUSSCHREIBEN
    private void initializeLevels() {
        // Level 1
        List<Monster> monsters1 = new ArrayList<>();
        monsters1.add(new Monster(
                "Kanalisationsratte",
                "Diese übergroßen Ratten sind äußerst aggressiv und versperren den Zugang in den Keller des Turms.",
                25, 20, 5, 8, 10, 1));

        levels.add(new Map(
                "Kanalisationzugang des dunklen Turms (Level 1)"
                        + "\n" + "Ein schrecklicher Gestank umgibt die Kanalisation.\n Du siehst am Ende des Kanalisationszugangs eine Gittertür aus der Licht scheint. \n" +
                        "Rote und aggressive Augen lurken aus der Dunkleheit hevor und blockieren dir den Zugang in den Turmkeller" + "\n" + monsters1.get(0).getName() + " greift dich an!",
                monsters1,
                false

        ));
        // Level 2
        List<Monster> monsters2 = new ArrayList<>();
        monsters2.add(new Monster(
                "Verpennter Gefängniswärter",
                "Dieser desorientierte und übermüdete Gefängniswärter kann hinterlistig erledigt werden.",
                40, 40, 7, 12, 20, 2));

        levels.add(new Map(
                "Keller des dunklen Turms (Level 1)"
                        + "\n" + "Die Gittertür quietscht, als du sie hinter dir schließt. \n Du siehst einige Kerkerzellen mit Monstern die dich im Blick haben. \n" +
                        "Am Ende des Kerkerkomplexes schläft ein Gefängniswärter auf dem Holzhocker neben einem Sekretärtisch und Holzkiste.",
                monsters2,
                false

        ));
        // Level 3
        List<Monster> monsters3 = new ArrayList<>();
        monsters3.add(new Monster(
                "Schattenbeschwörer",
                "Ein düsterer Magier, der dunkle Energien beschwört, um seine Feinde zu vernichten.",
                60, 50, 10, 15, 30, 3));

        levels.add(new Map(
                "Dunkler Turm - Magieretage (Level 3)"
                        + "\n" + "Ein kalter Wind weht durch die verlassenen Korridore der Magieretage. \n Dunkle Schatten tanzen an den Wänden, während du vorsichtig voranschreitest. \n" +
                        "Plötzlich materialisiert sich ein Schattenbeschwörer vor dir und greift dich an!",
                monsters3,
                false

        ));
        // Level 4
        List<Monster> monsters4 = new ArrayList<>();
        monsters4.add(new Monster(
                "Banshee",
                "Eine schreiende Banshee.",
                70, 65, 12, 18, 30, 4));

        levels.add(new Map(
                "Dunkler Turm - Verlorene Hallen (Level 4)"
                        + "\n" + "Ein kalter Wind weht durch die verlassenen Korridore der Magieretage. \n Dunkle Schatten tanzen an den Wänden, während du vorsichtig voranschreitest. \n" +
                        "Plötzlich materialisiert sich ein Schattenbeschwörer vor dir und greift dich an!",
                monsters3,
                false

        ));

        // Level 5
        List<Monster> monsters5 = new ArrayList<>();
        monsters5.add(new Monster(
                "Finsterer Hexenmeister",
                "Ein finsterer Hexenmeister, der dunkle Flüche und Zaubersprüche beherrscht, um seine Feinde zu vernichten.",
                100, 70, 15, 25, 50, 5));

        levels.add(new Map(
                "Dunkler Turm - Spitzenebene (Level 5)"
                        + "\n" + "Die Spitze des Turms ragt in den düsteren Himmel, umgeben von peitschenden Winden und knisternden Blitzen. \n Doch der eigentliche Sturm lauert im Inneren, wo der finstere Hexenmeister seine Macht entfesselt und dich herausfordert!",
                monsters5,
                false
        ));
        // Level 6
        List<Monster> monsters6 = new ArrayList<>();
        monsters6.add(new Monster(
                "Banshee",
                "Eine schreiende Banshee.",
                60, 50, 10, 15, 30, 6));

        levels.add(new Map(
                "Dunkler Turm - Verlorene Hallen (Level 4)"
                        + "\n" + "Ein kalter Wind weht durch die verlassenen Korridore der Magieretage. \n Dunkle Schatten tanzen an den Wänden, während du vorsichtig voranschreitest. \n" +
                        "Plötzlich materialisiert sich ein Schattenbeschwörer vor dir und greift dich an!",
                monsters6,
                false

        ));
        // Level 7
        List<Monster> monsters7 = new ArrayList<>();
        monsters7.add(new Monster(
                "Banshee",
                "Eine schreiende Banshee.",
                60, 50, 10, 15, 30, 7));

        levels.add(new Map(
                "Dunkler Turm - Verlorene Hallen (Level 4)"
                        + "\n" + "Ein kalter Wind weht durch die verlassenen Korridore der Magieretage. \n Dunkle Schatten tanzen an den Wänden, während du vorsichtig voranschreitest. \n" +
                        "Plötzlich materialisiert sich ein Schattenbeschwörer vor dir und greift dich an!",
                monsters7,
                false

        ));
        // Level 8
        List<Monster> monsters8 = new ArrayList<>();
        monsters8.add(new Monster(
                "Banshee",
                "Eine schreiende Banshee.",
                60, 50, 10, 15, 30, 8));

        levels.add(new Map(
                "Dunkler Turm - Verlorene Hallen (Level 4)"
                        + "\n" + "Ein kalter Wind weht durch die verlassenen Korridore der Magieretage. \n Dunkle Schatten tanzen an den Wänden, während du vorsichtig voranschreitest. \n" +
                        "Plötzlich materialisiert sich ein Schattenbeschwörer vor dir und greift dich an!",
                monsters8,
                false

        ));
        // Level 9
        List<Monster> monsters9 = new ArrayList<>();
        monsters9.add(new Monster(
                "Banshee",
                "Eine schreiende Banshee.",
                60, 50, 10, 15, 30, 9));

        levels.add(new Map(
                "Dunkler Turm - Verlorene Hallen (Level 4)"
                        + "\n" + "Ein kalter Wind weht durch die verlassenen Korridore der Magieretage. \n Dunkle Schatten tanzen an den Wänden, während du vorsichtig voranschreitest. \n" +
                        "Plötzlich materialisiert sich ein Schattenbeschwörer vor dir und greift dich an!",
                monsters9,
                false

        ));

        // Level 10
        List<Monster> monsters10 = new ArrayList<>();
        monsters10.add(new Monster(
                "Eisenwächter",
                "Ein riesiger Golem, der aus altem Eisen geschmiedet wurde und jeden Eindringling gnadenlos zermalmt.",
                200, 200, 15, 20, 40, 10));
        levels.add(new Map(
                "Dunkler Turm - Schatzkammerebene (Level 10)"
                        + "\n" + "Die Luft ist schwer von Goldglanz und reicher Beute, als du die Schatzkammerebene des Turms betrittst. \n Doch plötzlich erhebt sich ein massiver Eisenwächter aus den Trümmern und stellt sich dir in den Weg!",
                monsters10,
                true

        ));
        // Level 10
        List<Monster> monsters11 = new ArrayList<>();
        monsters11.add(new Monster(
                "Banshee",
                "Eine schreiende Banshee.",
                60, 50, 10, 15, 30, 11));

        levels.add(new Map(
                "Dunkler Turm - Verlorene Hallen (Level 4)"
                        + "\n" + "Ein kalter Wind weht durch die verlassenen Korridore der Magieretage. \n Dunkle Schatten tanzen an den Wänden, während du vorsichtig voranschreitest. \n" +
                        "Plötzlich materialisiert sich ein Schattenbeschwörer vor dir und greift dich an!",
                monsters11,
                false

        ));
        // Level 11
        List<Monster> monsters12 = new ArrayList<>();
        monsters12.add(new Monster(
                "Banshee",
                "Eine schreiende Banshee.",
                60, 50, 10, 15, 30, 12));

        levels.add(new Map(
                "Dunkler Turm - Turmspitze (Level 12)"
                        + "\n" + "Ein kalter Wind weht durch die verlassenen Korridore der Magieretage. \n Dunkle Schatten tanzen an den Wänden, während du vorsichtig voranschreitest. \n" +
                        "Plötzlich materialisiert sich ein Schattenbeschwörer vor dir und greift dich an!",
                monsters12,
                false

        ));
    };

    public Map getLevel(){
        return levels.get(currentLevelIndex);
}

    // Method to calculate exp amount based on dungeon level
    public int calculateExpForLevel(int levelNumber) {
        // check if level is valid
        if (levelNumber >= 1 && levelNumber <= levels.size()) {
            // exp grows with each level
            return INITIAL_EXP * levelNumber;
        } else {
            throw new IllegalArgumentException("Ungültige Level-Nummer");
        }
    }

    public int getCurrentLevelIndex() {
        return currentLevelIndex;
    }

    public void increaseLevel() {
        currentLevelIndex++;
    }

}
