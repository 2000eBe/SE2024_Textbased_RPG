import java.util.Scanner;
public class GameLogic {

    static Scanner scanner = new Scanner(System.in);
    static Shop shop;
    static Dungeon dungeon; // the tower to climb
    static PlayerCharacter player;//current player
    static boolean isRunning;
    static int completedLevels = 1; // 1 to start with level 1, gets increased through playing

    public GameLogic(PlayerCharacter player) {
        this.player = player;
        this.scanner = new Scanner(System.in);
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
                if (player.getCurrentLevel() != 0){
                  startGame();
                } else {
                    System.out.println("Spieler hat keine aktuelle Dungeon-Instanz");
                    showMainMenu();
                }
                break;
            case 2:
                showCharacterStatistics();
                break;
            case 3:
                openShop();
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


    static void initializeGame() {

        PlayerCharacter pc = new PlayerCharacter("DefaultName", CharacterClasses.MAGIER);
        dungeon = new Dungeon();
        GameLogic.printHeading("Willkommen zum Spiel!");
        GameLogic.setPlayer(pc);
        GameLogic.printHeading("Erstelle deinen eigenen Helden!");
        pc.CharacterCreationName();
        pc.CharacterCreationClass();

        System.out.println("TEST NAME IST: " + pc.getPlayerName());
        System.out.println("TEST Klasse IST: " + pc.getCharacterClass());

        pc.setCurrentLevel(1);
        showMainMenu();
    }

    // Start the dungeons
    public static  void startGame(){
        printHeading("DER DUNKLE TURM ERWARTET DICH");
        Map currentLevel = dungeon.getLevel(completedLevels);
        System.out.println(currentLevel.getDescription());
        CombatSystem.startCombatRound(player, currentLevel.getMonster());
        // TODO Wie inkrementell prüfen, welche Level bereits besiegt worden sind?
    }

    // Simple method to end the game
    private static void endGame() {
    }

    private static void openShop() {
        printHeading("DER MARKTPLATZ");
        shop = new Shop();
        shop.setPc(player);
        Shop.chooseVendor();

    }

    private static void showCharacterStatistics() {
        printHeading("CHARAKTERSTATISTIKEN");
        System.out.println("Charaktername: " + player.getPlayerName());
        System.out.println("Klasse: " + player.getCharacterClass());
        System.out.println("Verfügbare HP: " + player.getCurrentHP());
        // check if its a mage and can have MP
        if(CharacterClasses.MAGIER == player.getCharacterClass().getCharacterClass()){
            System.out.println("Verfügbare MP: " + player.getCurrentMP());
        }

        System.out.println("Getragene Waffe: ");
        System.out.println("Gesammeltes Vermögen: " + player.getCharacterInventory().getCurrencyAmount() + " Gold");
        System.out.println("Bezwungene Turm-Etagen: " + (completedLevels - 1));

        printSeperator(30);
        int input = readInt("Bitte (1) auswählen, um zum Menü zurückzukehren", 1);
        if( input == 1){
            showMainMenu();
        }
    }







    // getter and Setter
    public static void setPlayer(PlayerCharacter player) {
        GameLogic.player = player;
    }

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
}