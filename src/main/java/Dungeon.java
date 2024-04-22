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

    private void initializeLevels() {
        List<Monster> monsters1 = new ArrayList<>();
        monsters1.add(new Monster("Kanalisationsratte", "Diese übergroßen Ratten sind äußerst aggressiv und versperren den Zugang in den Keller des Turms.", 25, 20, 5, 8, 10, true));
        // Level 1
        levels.add(new Map(
                "Kanalisationzugang des dunklen Turms (Level 1)"
                        + "\n" + "Ein schrecklicher Gestank umgibt die Kanalisation.\nDu siehst am Ende des Kanalisationszugangs eine Gittertür aus der Licht scheint. \n" +
                        "Rote und aggressive Augen lurken aus der Dunkleheit hevor und blockieren dir den Zugang in den Turmkeller" + "\n" + monsters1.get(0).getName() + " greift dich an!",
                monsters1,
                false,
                false
        ));

        List<Monster> monsters2 = new ArrayList<>();
        monsters2.add(new Monster("Verpennter Gefängniswärter", "Dieser desorientierte und übermüdete Gefängniswärter kann hinterlistig erledigt werden.", 40, 40, 7, 12, 20, true));
        // Level 2
        levels.add(new Map(
                "Keller des dunklen Turms (Level 1)"
                        + "\n" + "Die Gittertür quietscht, als du sie hinter dir schließt. \n Du siehst einige Kerkerzellen mit Monstern die dich im Blick haben. \n" +
                        "Am Ende des Kerkerkomplexes schläft ein Gefängniswärter auf dem Holzhocker neben einem Sekretärtisch und Holzkiste.",
                monsters2,
                false,
                false
        ));
    };


    public Map getLevel(int levelNumber){
        if(levelNumber >= 1 && levelNumber <= levels.size()){
            return levels.get(levelNumber - 1); // level based on 1
        } else {
              throw new IllegalArgumentException("Ungültige Level-Nummer");
        }


}

    // Method to go to next dungeon level
    public void getNextDungeonLevel(){
        currentLevelIndex++;
        if (currentLevelIndex >= levels.size()){
            GameLogic.printHeading("SPIEL GEWONNEN!");
            System.out.println("Du hast die Gefahren des Turmes gebannt! Das ganze Königreich ist dir dankbar!");
            System.out.println("Du verlässt den bereinigten Turm. Die königlichen Truppen werden sich darum kümmern.");
            GameLogic.showMainMenu();
        } else {
            System.out.println("Du betrittst die nächste Etage:" + (currentLevelIndex+1) + " des Turmes");
        }
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


}
