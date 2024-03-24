import java.util.ArrayList;
import java.util.List;

public class Dungeon {

    private List<Map> levels;
    public Dungeon(){
        levels = new ArrayList<>();
        initializeLevels();
    }

    private void initializeLevels() {
        // Level 1
    levels.add(new Map(
            ("Kanalisationzugang des dunklen Turms (Level 1)"
                    + "\n" + "Ein schrecklicher Gestank umgibt die Kanalisation. \n Du siehst am Ende des Kanalisationszugangs eine Gittertür aus der Licht scheint. \n" +
                    "Rote und aggressive Augen lurken aus der Dunkleheit hevor und blockieren dir den Zugang in den Turmkeller"),
            new Monster(
                    "Kanalisationratten",
                    "Diese übergroßen Ratten sind äußerst aggressiv und versperren den Zugang in den Keller des Turms.",
                    25,20, 5, 8,10,5,true),
            3,
            false,
            false));
        // Level 2
    levels.add(new Map(
                ("Keller des dunklen Turms (Level 1)"
                        + "\n" + "Die Gittertür quietscht, als du sie hinter dir schließt. \n Du siehst einige Kerkerzellen mit Monstern die dich im Blick haben. \n" +
                        "Am Ende des Kerkerkomplexes schläft ein Gefängniswärter auf dem Holzhocker neben einem Sekretärtisch und Holzkiste."),
                new Monster(
                        "Verpennter Gefängniswärter",
                        "Dieser desorientierte und übermüdete Gefängniswärter kann hinterlistig erledigt werden.",
                        40,40, 7, 12,20,5,true),
                3,
                false,
                false));
    };


    public Map getLevel(int levelNumber){
        if(levelNumber >= 1 && levelNumber <= levels.size()){
            return levels.get(levelNumber - 1); // level based on 1
        } else {
              throw new IllegalArgumentException("Ungültige Level-Nummer");
        }

}
}
