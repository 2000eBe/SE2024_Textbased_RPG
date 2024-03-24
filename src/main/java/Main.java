import java.util.Random;
import java.util.Scanner;

// Main Class
public class Main {
    public static final Scanner userinput = new Scanner(System.in);
    public static final Random rand = new Random();


    public static void main(String[] args) {
        PlayerCharacter player = new PlayerCharacter("Defaultname", CharacterClasses.WAFFENMEISTER);
        GameEngine gameEngine1 = new GameEngine(player, userinput);
        gameEngine1.runGame();


    }


}
