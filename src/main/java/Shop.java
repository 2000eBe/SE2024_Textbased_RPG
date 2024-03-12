

// This class represents different vendors / shops and their stock
public class Shop {

    static PlayerCharacter pc;

    // Method to show different Vendors
    static void chooseVendor(){
        System.out.println("Es tummeln sich viele Händler auf dem Marktplatz"
        + "\n Welche Händler möchtest du aufsuchen? \n" +
                        "(1) für den Alchemisten \n" +
                        "(2) für den Waffenschmied \n" +
                        "(3) für das Ärztehaus \n" +
                        "(4) die Stadt verlassen"
        );

        int choice = GameLogic.readInt("Wähle einen Händler", 4);

        switch (choice){
            // Alchemy vendor
            case 1:
                System.out.println("Hier die Alchemistenmethode");
                VisitAlchemyVendor();
                break;
            case 2:
                // Weapon Smith
                VisitWeaponSmith();
                System.out.println("hier ist der Waffenschmied");
                break;
            case 3:
                // Town Healer
                VisitTownHealer();
                break;
            case 4:
                System.out.println("Du verlässt die Stadt wieder.");
                GameLogic.printSeperator(30);
                GameLogic.showMainMenu();
        }
    }

    // Town Healer Method
    private static void VisitTownHealer() {
        System.out.println("Du betrittst das Ärztehaus. Du kannst dich für 20 Gold heilen lassen.");
        System.out.println("(1) für Heilung (Kosten: 20 Gold)");
        System.out.println("(2) du möchtest keine Heilung und verlässt das Ärztehaus wieder.");

        int input = GameLogic.readInt("-> ", 2);
        if(input == 1){
            if (pc.getCurrentHP() >= pc.getCharacterClass().getHp()){
                System.out.println("Du bist nicht verwundet. Der Heiler schickt dich fort.");
                GameLogic.printSeperator(30);
                // go back to marketplace
                chooseVendor();
            }

            if (checkAffordable(20)){
                payGold(20);
                // get difference between max possible hp and current hp
                int damageAmount = pc.getCharacterClass().getHp() - pc.getCurrentHP();
                pc.heal(damageAmount);
                System.out.println("Der Heiler hat " + damageAmount + " HP wiederhergestellt! Du gehst erholt wieder auf den Marktplatz");
                GameLogic.printSeperator(30);
                chooseVendor();
            }
            System.out.println("Du kannst dir dies nicht leisten! Der Heiler schickt dich fort.");
            GameLogic.printSeperator(30);
            chooseVendor();

        } else if (input == 2){
            GameLogic.printSeperator(30);
            chooseVendor();
        }
    }


    private static void VisitWeaponSmith() {
    }

    private static void VisitAlchemyVendor() {
        System.out.println("Du betrittst das Alchemielabor. Du kannst dir das Sortiment anschauen.");
        System.out.println("(1) Wenn das Sortiment sehen möchtest.");
        System.out.println("(2) Wenn du wieder zum Marktplatz zurückkehren möchtest.");

        int input = GameLogic.readInt("-> ", 2);


    }


    public static void setPc(PlayerCharacter pc){
        Shop.pc = pc;
    }
    // Currency Operations / Methods

    // Check, if player can afford object or service
    private static boolean checkAffordable(int amount){
        return pc.getCharacterInventory().getCurrencyAmount() >= amount;
    }

    // deduct the money used in the shop / marketplace from character inventory
    private static void payGold(int amount){
        pc.getCharacterInventory().setCurrencyAmount(
                pc.getCharacterInventory().getCurrencyAmount() - amount
        );
    }
}
