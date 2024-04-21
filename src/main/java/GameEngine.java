import java.util.Scanner;

// This class implements the main GameEngine & Loop
public class GameEngine {
    private boolean isRunning;
    private PlayerCharacter player;
    private GameLogic gameLogic;
    private Scanner scanner;

    public void runGame(){
        GameLogic.initializeGame();
    }

    public GameEngine(PlayerCharacter player, Scanner scanner){
        this.player = player;
        this.scanner = scanner;
        this.gameLogic = new GameLogic(player);
    }





}