import java.util.Scanner;
public class GameLogic {

     Shop shop;
     Dungeon dungeon; // the tower to climb
     PlayerCharacter player;//current player
     static boolean isTowerPlayable = true;
    private  CombatSystem combatSystem;


    public GameLogic(PlayerCharacter player) {
        this.player = player;
        this.dungeon = new Dungeon();
        combatSystem = new CombatSystem(player);
        combatSystem.setDungeon(dungeon);
        shop = new Shop(player);
    }

    public static void endgame() {
        GameUtility.printHeading("HERZLICHEN GLÜCKWUNSCH!");
        System.out.println("Du hast das Königreich vor Ivan und seinen Schergen befreit!");
        System.out.println("Du hast das Spiel durchgespielt! ");
        System.out.println("Geh ins Hauptmenü um deine Charakterstatistiken zu betrachten!");
        isTowerPlayable = false;
        GameUtility.printSeperator(30);

    }

    // Method for Main Menu
    public void showMainMenu(){
        do {
            System.out.println("Hauptmenü");
            System.out.println("(1) zum Spiel starten");
            System.out.println("(2) Charakterstatistiken und Informationen");
            System.out.println("(3) Händler in der Stadt besuchen");
            System.out.println("(4) Spiel beenden");

            int choice = GameUtility.readInt("Bitte wähle eine Option aus: ", 4);

            switch (choice){
                case 1:
                    if (player.getCurrentLevel() != 0 && isTowerPlayable){
                        startGame();
                    } else {
                        GameUtility.printSeperator(30);
                        System.out.println(
                                "Du hast den Turm bereits bezwungen! \n" +
                                "Bitte beginne ein neuen Spielstand!");
                        GameUtility.printSeperator(30);
                    }
                    break;
                case 2:
                    showCharacterStatistics();
                    break;
                case 3:
                    openShop();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Ungültige Option. Bitte versuche es erneut!");
            }
        }while (true);

    }


     void initializeGame() {

        GameUtility.printHeading("Willkommen zum Spiel!");
        GameUtility.printHeading("Erstelle deinen eigenen Helden!");
        player.CharacterCreationName();
        player.CharacterCreationClass();
        showMainMenu();
    }

    // Start the dungeons
    public void startGame(){
        GameUtility.printHeading("DER DUNKLE TURM ERWARTET DICH");
        do {
            Map currentLevel = dungeon.getLevel();
            System.out.println(currentLevel.getDescription());
            if (!combatSystem.startCombatRound(player, currentLevel.getMonster())){
                break;
            }
        } while (true);

    }

    private void openShop() {
        GameUtility.printHeading("DER MARKTPLATZ");
        shop.chooseVendor();
    }

    private void showCharacterStatistics() {
        GameUtility.printHeading("CHARAKTERSTATISTIKEN");
        System.out.println("Charaktername: " + player.getPlayerName());
        System.out.println("Klasse: " + player.getCharacterClass());
        System.out.println("Verfügbare HP: " + player.getCurrentHP());
        // check if its a mage and can have MP
        if(CharacterClasses.MAGIER == player.getCharacterClass().getCharacterClass()){
            System.out.println("Verfügbare MP: " + player.getCurrentMP());
        }

        System.out.println("Aktuelle getragene Waffe: " + player.getCharacterInventory().getCurrentWeapon());
        System.out.println("Gesammeltes Vermögen: " + player.getCharacterInventory().getCurrencyAmount() + " Gold");
        System.out.println("Bezwungene Turm-Etagen: " + (dungeon.getCurrentLevelIndex()));
        GameUtility.printSeperator(30);
    }
    // getter and Setter
    public void setPlayer(PlayerCharacter player) {
        this.player = player;
    }

}