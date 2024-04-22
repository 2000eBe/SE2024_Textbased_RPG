import java.util.Scanner;
 class IngameMenu {

     private final PlayerCharacter player;

     public IngameMenu(PlayerCharacter player){
         this.player = player;
     }

     public boolean showIngameMenuInCombat(){
         do {
             System.out.println("Menü im Kampf");
             System.out.println("(1) um Kampf fortzuführen");
             System.out.println("(2) um Trank einzusetzen.");
             System.out.println("(3) um Waffe zu wechseln.");
             System.out.println("(4) um dem Kampf und Turm fliehen.");

             int choice = GameUtility.readInt("Bitte wähle eine Option aus: ", 4);

             switch (choice){
                 case 1:
                     return true;
                 case 2:
                     usePotionInCombat();
                     break;
                 case 3:
                     changeWeaponInCombat();
                     break;
                 case 4:
                     GameUtility.printSeperator(30);
                     System.out.println("Du fliehst vor dem Kampf und kehrst um.");
                     return false;
                 default:
                     break;
             }
         }while (true);
     }

     // Use Potion in Combat
     private void usePotionInCombat() {
         boolean validInput = false;
         do {
             try{
                 GameUtility.printSeperator(30);
                 CharacterInventory inventory = player.getCharacterInventory();
                 inventory.showInventoryPotions();
                 int availableInventorySpace = inventory.getNumAvailableInventorySpace();
                 int itemPosition = GameUtility.readInt(
                         "Wähle einen Trank aus den: " + availableInventorySpace + " Inventarplätzen aus. \n" +
                                 "(0) wenn kein Trank verwendet werden soll und um zum Menü zurückzukehren",
                         availableInventorySpace);
                 // Use no Potion and go back to menu
                 if (itemPosition == 0){
                     System.out.println("Rückkehr zum Menü.");
                     GameUtility.printSeperator(30);
                     return; // back to menu
                 }
                 // Use Potion from inventory
                 inventory.useItemFromInventory(--itemPosition);
                 validInput = true;
             } catch (IllegalArgumentException e){
                 System.out.println("Ungülitge Eingabe. Bitte wähle eine gültige Position im Inventar");
             }
         } while (!validInput);
     }

     private void changeWeaponInCombat() {
         boolean validInput = false;
         CharacterClasses playerCharacterClass = player.getCharacterClass().getCharacterClass();
         if (playerCharacterClass == CharacterClasses.WAFFENMEISTER) {
         do {
             try {
                 GameUtility.printSeperator(30);
                 CharacterInventory inventoryWeapons = player.getCharacterInventory();
                 int availableWeaponSlots = inventoryWeapons.getNumAvailableWeaponInventorySpace();
                 inventoryWeapons.showInventoryWeapons();
                 int itemPosition = GameUtility.readInt(
                         "Wähle eine Waffe aus den " + availableWeaponSlots +
                                 " Waffenplätzen im Inventar eine zum Tausch aus. \n"
                                 + "(0) wenn keine Waffe getauscht werden soll und zum Menü zurückkehren.",
                         availableWeaponSlots);
                 // don't change weapon and go back to menu
                 if (itemPosition == 0) {
                     System.out.println("Rückkehr zum Menü.");
                     GameUtility.printSeperator(30);
                     return;
                 }
                 // change corresponding weapon
                 inventoryWeapons.changeWeaponFromInventory(itemPosition);
                 validInput = true;
             } catch (IllegalArgumentException e) {
                 System.out.println("Ungültige Eingabe. Bitte wähle eine gültige Position im Waffeninventar.");
             }

         } while (!validInput) ;
         } else if (playerCharacterClass == CharacterClasses.MAGIER){
             System.out.println("Magier können nur einen Zauberstab führen. Sie können die Waffe nicht wechseln. \n"
             + "Rückkehr zum Menü folgt.");
             GameUtility.printSeperator(30);
     }
     }


 }
