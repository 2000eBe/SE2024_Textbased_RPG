public class WeaponVendor implements ShopInterface {
    private void showAvailableUpgrades(Weapon weapon, PlayerCharacter player) {
        WeaponEquipment.getInstance().showAvailableUpgradesForWeapon(weapon, player);
    }
    @Override
    public void visit(PlayerCharacter player) {
        System.out.println("Du betrittst die Waffenschmiede. Du kannst deine Waffe verbessern lassen.");
        System.out.println("Für welche Waffe suchst du eine Verbesserung?");
        // for mages
        if (player.getCharacterClass().getCharacterClass() == CharacterClasses.MAGIER){
            System.out.println("(1) Zauberstab (Magier)");
            System.out.println("(2) Wenn du wieder zum Marktplatz zurückkehren möchtest.");

            int input = GameUtility.readInt("-> ", 2);
            if (input == 1 ){
                showAvailableUpgrades(player.getCharacterInventory().getCurrentWeapon(), player);
            }
            if (input == 2){
                System.out.println("Du verlässt die Waffenschmiede und kehrst zur Stadt zurück");
                GameUtility.printSeperator(30);
                return;
            }
            return;
        }
        System.out.println("(1) Schwerter (Waffenmeister)");
        System.out.println("(2) Streitkolben (Waffenmeister)");
        System.out.println("(3) Äxte (Waffenmeister)");
        System.out.println("(4) Wenn du wieder zum Marktplatz zurückkehren möchtest");

        int input = GameUtility.readInt("-> ", 4);
        switch (input){
            case 1:
                showAvailableUpgrades(player.getCharacterInventory().getWeaponAtIndex(0), player); // auf platz 0
                break;
            case 2:
                showAvailableUpgrades(player.getCharacterInventory().getWeaponAtIndex(2), player); // in wepaoniventory auf platz 2
                break;
            case 3:
                showAvailableUpgrades(player.getCharacterInventory().getWeaponAtIndex(1), player); // in Weaponinventory auf Platz 1
                break;
            case 4:
                System.out.println("Du verlässt die Waffenschmiede!");
                return;
        }
    }
}
