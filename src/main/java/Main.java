import java.util.Random;
import java.util.Scanner;

// Main Class
public class Main {
    public static final Scanner userinput = new Scanner(System.in);
    public static final Random rand = new Random();
    PlayerCharacter pc = new PlayerCharacter();

    public static void main(String[] args) {

        PlayerCharacter pc = new PlayerCharacter();
        pc.setPlayerName("DefaultName Test");
        GameLogic.printHeading("Erstelle deinen eigenen Helden!");
       pc.CharacterCreationName();
       pc.CharacterCreationClass();

        System.out.println("TEST NAME IST: " + pc.getPlayerName());


    }


}
