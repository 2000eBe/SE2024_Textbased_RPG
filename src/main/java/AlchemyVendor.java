public class AlchemyVendor implements ShopInterface {


    // buy methods for each shop
    void buyPotion(PotionItems potion, PlayerCharacter player) {
        int price = potion.getPrice();

        if (!player.getCharacterInventory().checkAffordable(price)) {
            System.out.println("Du kannst dir den Trank nicht leisten. Der Alchemist schickt dich fort");
            GameUtility.printSeperator(30);
            return;
        }

        if (player.getCharacterInventory().checkInventorySpace()) {
            System.out.println("Du hast keinen Platz im Inventar und kannst nichts kaufen. Du verlässt den Laden!");
            System.out.println(" ");
            return;
        }

            player.getCharacterInventory().payGold(price);
            player.getCharacterInventory().addPotionItemToInventory(potion);
            System.out.println("Du hast einen Trank erworben und schaust dich weiter im Alchemielabor um.");
            System.out.println(" ");
            return;

    }

    @Override
    public void visit(PlayerCharacter player) {
        do {
            PotionItems.HealthPotion healthPotion = new PotionItems.HealthPotion();
            PotionItems.ManaPotion manaPotion = new PotionItems.ManaPotion();
            int healthPotionPrice = healthPotion.getPrice();
            int manaPotionPrice = manaPotion.getPrice();

            System.out.println("Du betrittst das Alchemielabor. Du kannst dir das Sortiment anschauen.");
            System.out.println("(1) Wenn das Sortiment sehen möchtest.");
            System.out.println("(2) Wenn du wieder zum Marktplatz zurückkehren möchtest.");

            int input = GameUtility.readInt("-> ", 2);

            // show stock
            if (input == 1) {
                System.out.println("Du hast die Auswahl zwischen Heiltränken und Manatränken.");
                System.out.println("(1) Wenn du ein Heiltrank möchtest. (Kosten: " + healthPotionPrice + " Gold)");
                System.out.println("(2) Wenn du ein Manatrank möchtest. (Kosten: " + manaPotionPrice + " Gold)");
                System.out.println("(3) Wenn du doch nichts kaufen möchtest und den Laden verlassen möchtest.");
                int input2 = GameUtility.readInt("-> ", 3);

                switch (input2) {
                    case 1:
                        buyPotion(new PotionItems.HealthPotion(), player);
                        break;
                    case 2:
                        buyPotion(new PotionItems.ManaPotion(), player);
                        break;
                    case 3:
                        System.out.println("Du verlässt das Alchemielabor und kehrst zur Stadt zurück");
                        GameUtility.printSeperator(30);
                        return;
                    default:
                        System.out.println("Ungültige Eingabe. Bitte versuche es erneut mit einer Zahl zwischen 1 und 3.");
                }

            }
            //leave
            else if (input == 2) {
                System.out.println("Du verlässt das Alchemielabor und kehrst zur Stadt zurück");
                GameUtility.printSeperator(30);
                return;
            }
        } while (true);
    }
}
