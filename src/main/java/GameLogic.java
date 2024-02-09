import java.util.Scanner;
public class GameLogic {

    static Scanner scanner = new Scanner(System.in);
    static PlayerCharacter player; //current player
    static boolean isRunning;

    // Method to format dialogues a little bit prettier
        public static void printSeperator(int n){
            for (int i = 0; i < n; i++){
                System.out.print("-");
            }
            System.out.println();
        }

    // Method to print a heading

        public static void printHeading(String title){
                printSeperator(30);
                System.out.println(title);
                printSeperator(30);
        }
    // Method to get user input from console
        public static int readInt(String prompt, int userChoice){
                int input;

                do {
                    System.out.println(prompt);
                    try{
                        input = Integer.parseInt(scanner.next());
                    } catch (Exception e){
                        input = -1;
                        System.out.println("Bitte ein Integer einfügen!");
                    }
                } while (input < 1 || input > userChoice);
                return input;
            }

    // Method to simulate clearing of the console for a cleaner look
    public static void clearConsole(){
            for (int i = 0; i < 100; i++){
                System.out.println();
            }
    }

    // IO for critical hit
    public static void playerCrit(){
        System.out.println("Du hast kritischen Schaden zugefügt! (x2 Schaden zugefügt)");
    }

    public static void monsterCrit(){
        System.out.println("Dein Gegner hat dich kritisch verwundet! (x2 Schaden erhalten)" );
    }
}
