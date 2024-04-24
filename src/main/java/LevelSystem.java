// This class implements the level system, offering information about the current level and XP status
public class LevelSystem {

    private static final  int[] LEVEL_UP_EXPERIENCE = {0,0, 500, 1000, 2000, 4000};

    private  int currentLevel;
    private int currentExp;
    private int levelExp;


    public LevelSystem(int startingLevel){
        this.currentLevel = startingLevel;
        this.currentExp = 0;
        this.levelExp = LEVEL_UP_EXPERIENCE[currentLevel];
    }

    public void addExp(int exp){
        currentExp += exp;
        while (currentExp >= levelExp && currentLevel < LEVEL_UP_EXPERIENCE.length){
            currentExp -= levelExp;
            levelUp();
            levelExp = LEVEL_UP_EXPERIENCE[currentLevel];
        }
    }

    private void levelUp() {
        currentLevel++;
        levelExp = LEVEL_UP_EXPERIENCE[currentLevel];
        System.out.println("Herzlichen Glückwunsch! Du bist ein Level aufgestiegen!" + "\n" + "Du bist nun Level: " + currentLevel);
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

}
