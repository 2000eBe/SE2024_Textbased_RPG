import java.util.Scanner;

// This class implements the main GameEngine & Loop
public class GameEngine {
    private boolean isRunning;
    private PlayerCharacter player;
    private GameLogic gameLogic;
    private Scanner scanner;

    public void runGame(){
        // Check if person wants to continue or start new game
        //checkPlayerGameChoice();
        // Initialize the game
        initializeGame();

        // Main Loop for game
        //while (GameLogic.isRunning) {
            // Spielupdate durchführen
           // updateGame();

            // Spieleraktionen verarbeiten
           // processPlayerActions();

            // Gegneraktionen verarbeiten
          //  processEnemyActions();

            // Spielzustand überprüfen
           // checkGameStatus();
        }

        public GameEngine(PlayerCharacter player, Scanner scanner){
        this.player = player;
        this.scanner = scanner;
        }

        public void startGame(){
        int currentLevel = 1; // start with level 1

            while (true){
                Map currentMap = player.getCurrentDungeon().getLevel(currentLevel);
                System.out.println("Aktuelles Level: " + currentLevel);
                System.out.println(currentMap.getDescription());









                // Finish the game
                if (currentLevel > player.getCurrentDungeon().getLevels().size()){
                    System.out.println("Herzlichen Glückwunsch! Du hast die Stadt vor der Bedrohung des dunklen Turms gerettet!");
                    break;
                }


                GameLogic.printSeperator(30);

                int choice = GameLogic.readInt("Möchtest du zum nächsten Level gehen? ", 2);
                System.out.println("(1) für das nächste Level" + "\n" + "(2) zum Menü (Statistiken, Stadt besuchen, Spiel beenden) zurückkehren");
                if(choice == 1){
                    currentLevel++;
                } else if (choice == 2){
                    GameLogic.showMainMenu();

                }



            }

        }
    private void checkPlayerGameChoice() {
        System.out.println("Möchtest du ein neues Spiel beginnen oder ein Spielstand fortführen?");

    }

    // end the Game
       // endGame();
    //}

    private static void endGame() {
        // hier z.b. erreichte Statistiken
        GameLogic.printHeading("Das Spiel wurde beendet. Auf Wiedersehen!");
    }

    private static void processPlayerActions() {
        GameLogic.showMainMenu();
    }

    private static void initializeGame() {
        GameLogic.printHeading("Willkommen zum Spiel!");
        PlayerCharacter pc = new PlayerCharacter("DefaultName", CharacterClasses.MAGIER);
        GameLogic.setPlayer(pc);
        GameLogic.printHeading("Erstelle deinen eigenen Helden!");
        pc.CharacterCreationName();
        pc.CharacterCreationClass();

        System.out.println("TEST NAME IST: " + pc.getPlayerName());
        System.out.println("TEST Klasse IST: " + pc.getCharacterClass());

        GameLogic.showMainMenu();
    }


}
