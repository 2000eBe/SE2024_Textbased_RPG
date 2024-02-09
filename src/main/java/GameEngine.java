// This class implements the main GameEngine & Loop
public class GameEngine {
    private boolean isRunning;
    private PlayerCharacter player;
    private GameLogic gameLogic;
    public void runGame(){
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
