import java.util.Scanner;
public class GameLogic {

    static Scanner scanner = new Scanner(System.in);
    static PlayerCharacter player;//current player
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



    // Method for Main Menu

    public static void showMainMenu(){
        System.out.println("Hauptmenü");
        System.out.println("(1) zum Spiel starten");
        System.out.println("(2) Charakterstatistiken und Informationen");
        System.out.println("(3) Händler in der Stadt besuchen");
        System.out.println("(4) Spiel beenden");

        int choice = readInt("Bitte wähle eine Option aus: ", 4);

        switch (choice){
            case 1:
                //startGame();
                System.out.println("Hier würde das Spiel starten... wenn es da wäre!");
                break;
            case 2:
                showCharacterStatistics();
                //System.out.println("Hier wären Statistiken zum Charakter... wenn es da wäre!");
                break;
            case 3:
                //openShop();
                System.out.println("Hier wären Händler, die sind aber noch auf dem Weg");
                break;
            case 4:
                //endGame();
                break;
            default:
                System.out.println("Ungültige Option. Bitte versuche es erneut!");
                showMainMenu();
                break;
        }

    }

    private static void endGame() {
    }

    private static void openShop() {
    }

    private static void showCharacterStatistics() {
            printHeading("CHARAKTERSTATISTIKEN");
        System.out.println("Charaktername: " + player.getPlayerName());
        System.out.println("Klasse: " + player.getCharacterClass());
        System.out.println("Verfügbare HP: " + player.getCharacterClass().getHp());
        // check if its a mage and can have MP
        if(CharacterClasses.MAGIER == player.getCharacterClass().getCharacterClass()){
            System.out.println("Verfügbare MP: " + player.getCharacterClass().getMp());
        }

        System.out.println("Getragene Waffe: ");
        System.out.println("Gesammeltes Vermögen: ");
        System.out.println("Bezwungene Turm-Etagen: ");

        printSeperator(30);
        int input = readInt("Bitte (1) auswählen, um zum Menü zurückzukehren", 1);
        if( input == 1){
            showMainMenu();
        }
        }

    private static void startGame() {
    }

    // Method to simulate clearing of the console for a cleaner look
    public static void clearConsole(){
            for (int i = 0; i < 100; i++){
                System.out.println();
            }
    }



    // getter and Setter

    public static void setPlayer(PlayerCharacter player) {
        GameLogic.player = player;
    }

    // IO for critical hit
    public static void playerCrit(){
        System.out.println("Du hast kritischen Schaden zugefügt! (x2 Schaden zugefügt)");
    }

    public static void monsterCrit(){
        System.out.println("Dein Gegner hat dich kritisch verwundet! (x2 Schaden erhalten)" );
    }
}
