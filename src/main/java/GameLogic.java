import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class GameLogic {

     Dungeon dungeon; // the tower to climb
     PlayerCharacter player;//current player
     static boolean isTowerPlayable = true;
    private  CombatSystem combatSystem;
    private List<ShopInterface> vendors;


    public GameLogic(PlayerCharacter player) {
        this.player = player;
        this.dungeon = new Dungeon();
        combatSystem = new CombatSystem(player);
        combatSystem.setDungeon(dungeon);
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
         vendors = new ArrayList<>();
         vendors.add(new AlchemyVendor());
         vendors.add(new WeaponVendor());
         vendors.add(new TownhealerVendor());
         vendors.add(new InnVendor());
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
        do {
            System.out.println("Es tummeln sich viele Händler auf dem Marktplatz"
                    + "\nWelche Händler möchtest du aufsuchen? \n" +
                    "(1) für den Alchemisten \n" +
                    "(2) für den Waffenschmied \n" +
                    "(3) für das Ärztehaus \n" +
                    "(4) für das Gasthaus \n" +
                    "(5) die Stadt verlassen"
            );

            int choice = GameUtility.readInt("Wähle einen Händler", 5);

            switch (choice){
                // Alchemy vendor
                case 1:
                    vendors.get(0).visit(player);
                    break;
                case 2:
                    // Weapon Smith
                    vendors.get(1).visit(player);
                    break;
                case 3:
                    // Town Healer
                    vendors.get(2).visit(player);
                    break;
                case 4:
                    // Town inn
                    vendors.get(3).visit(player);
                    break;
                case 5:
                    System.out.println("Du verlässt die Stadt wieder.");
                    GameUtility.printSeperator(30);
                    return;
            }
        } while (true);
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