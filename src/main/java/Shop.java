// This class represents different vendors / shops and their stock
public class Shop {

    PlayerCharacter player;
    public Shop(PlayerCharacter player){
        this.player = player;
    }

    // Method to show different Vendors
    void chooseVendor(){
        System.out.println("Es tummeln sich viele Händler auf dem Marktplatz"
        + "\nWelche Händler möchtest du aufsuchen? \n" +
                        "(1) für den Alchemisten \n" +
                        "(2) für den Waffenschmied \n" +
                        "(3) für das Ärztehaus \n" +
                        "(4) die Stadt verlassen"
        );

        int choice = GameUtility.readInt("Wähle einen Händler", 4);

        switch (choice){
            // Alchemy vendor
            case 1:
                VisitAlchemyVendor();
                break;
            case 2:
                // Weapon Smith
                VisitWeaponSmith();
                break;
            case 3:
                // Town Healer
                VisitTownHealer();
                break;
            case 4:
                System.out.println("Du verlässt die Stadt wieder.");
                GameUtility.printSeperator(30);
        }
    }

    // Town Healer Method
    private void VisitTownHealer() {
        System.out.println("Du betrittst das Ärztehaus. Du kannst dich für 20 Gold heilen lassen.");
        System.out.println(player.getCurrentHP());
        System.out.println("(1) für Heilung (Kosten: 20 Gold)");
        System.out.println("(2) du möchtest keine Heilung und verlässt das Ärztehaus wieder.");


        int input = GameUtility.readInt("-> ", 2);
        if(input == 1){
            if (player.getCurrentHP() >= player.getCharacterClass().getHp()){
                System.out.println("Du bist nicht verwundet. Der Heiler schickt dich fort.");
                GameUtility.printSeperator(30);
                // go back to marketplace
                chooseVendor();
                return;
            }

            if (player.getCharacterInventory().checkAffordable(20)){
                player.getCharacterInventory().payGold(20);
                // get difference between max possible hp and current hp
                int damageAmount = player.getCharacterClass().getHp() - player.getCurrentHP();
                player.heal(damageAmount);
                System.out.println("Der Heiler hat " + damageAmount + " HP wiederhergestellt! Du gehst erholt wieder auf den Marktplatz");
                GameUtility.printSeperator(30);
                chooseVendor();
                return;
            }
            System.out.println("Du kannst dir dies nicht leisten! Der Heiler schickt dich fort.");
            GameUtility.printSeperator(30);
            chooseVendor();

        } else if (input == 2){
            GameUtility.printSeperator(30);
            chooseVendor();
        }
    }

    // TODO add Weaponupgrading functionality to WeaponSmith
    //  Town Weapon Smith Method
    private void VisitWeaponSmith() {
        System.out.println("Du betrittst die Waffenschmiede. Du kannst deine Waffe verbessern lassen.");
        System.out.println("(1) Wenn die Waffe verbessern möchtest.");
        System.out.println("(2) Wenn du wieder zum Marktplatz zurückkehren möchtest.");

        int input = GameUtility.readInt("Wähle einen Händler", 2);

        if (input == 1 ){

        }
        if (input == 2){
            System.out.println("Du verlässt die Waffenschmiede und kehrst zur Stadt zurück");
            GameUtility.printSeperator(30);
            chooseVendor();
        }

    }


    // Alchemy Laboratory Method
    private void VisitAlchemyVendor() {

        PotionItems.HealthPotion healthPotion = new PotionItems.HealthPotion();
        PotionItems.ManaPotion manaPotion = new PotionItems.ManaPotion();
        int healthPotionPrice = healthPotion.getPrice();
        int manaPotionPrice = manaPotion.getPrice();

        System.out.println("Du betrittst das Alchemielabor. Du kannst dir das Sortiment anschauen.");
        System.out.println("(1) Wenn das Sortiment sehen möchtest.");
        System.out.println("(2) Wenn du wieder zum Marktplatz zurückkehren möchtest.");

        int input = GameUtility.readInt("-> ", 2);

        // show stock
        if (input == 1){
            System.out.println("Du hast die Auswahl zwischen Heiltränken und Manatränken.");
            System.out.println("(1) Wenn du ein Heiltrank möchtest. (Kosten: " + healthPotionPrice + " Gold)");
            System.out.println("(2) Wenn du ein Manatrank möchtest. (Kosten: " + manaPotionPrice + " Gold)");
            System.out.println("(3) Wenn du doch nichts kaufen möchtest und den Laden verlassen möchtest.");
            int input2 = GameUtility.readInt("-> ", 3);

            switch (input2){
                case 1:
                    buyPotion(new PotionItems.HealthPotion());
                    break;
                case 2:
                    buyPotion(new PotionItems.ManaPotion());
                    break;
                case 3:
                    System.out.println("Du verlässt das Alchemielabor und kehrst zur Stadt zurück");
                    GameUtility.printSeperator(30);
                    chooseVendor();
                    break;
                default:
                    System.out.println("Ungültige Eingabe. Bitte versuche es erneut mit einer Zahl zwischen 1 und 3.");
            }

        }
        //leave
        else if (input == 2){
            System.out.println("Du verlässt das Alchemielabor und kehrst zur Stadt zurück");
            GameUtility.printSeperator(30);
            chooseVendor();
        }


    }

    // buy methods for each shop
    void buyPotion(PotionItems potion){
        int price = potion.getPrice();

        if (!player.getCharacterInventory().checkAffordable(price)){
            System.out.println("Du kannst dir den Trank nicht leisten. Der Alchemist schickt dich fort");
            GameUtility.printSeperator(30);
             chooseVendor();
        } else if (player.getCharacterInventory().checkInventorySpace()) {
            System.out.println("Du hast keinen Platz im Inventar und kannst nichts kaufen. Du verlässt den Laden!");
            System.out.println(" ");
            chooseVendor();
        } else {
            player.getCharacterInventory().payGold(price);
            player.getCharacterInventory().addPotionItemToInventory(potion);
            System.out.println("Du hast einen Trank erworben und schaust dich weiter im Alchemielabor um.");
            System.out.println(" ");
            VisitAlchemyVendor();
        }
    }



    //TODO Weaponupgrading
    private void buyWeaponUpgrade(){

    }
}
