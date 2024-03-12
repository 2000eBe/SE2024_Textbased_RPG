// This class implements the main GameEngine & Loop
public class GameEngine {
    private boolean isRunning;
    private PlayerCharacter player;
    private GameLogic gameLogic;
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
