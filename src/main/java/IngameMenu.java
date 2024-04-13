import java.util.Scanner;
 class IngameMenu {
     public static void showIngameMenuInCombat(PlayerCharacter pc){
         System.out.println("Menü im Kampf");
         System.out.println("(1) um Kampf fortzuführen");
         System.out.println("(2) um Trank einzusetzen.");
         System.out.println("(3) um Waffe zu wechseln.");
         System.out.println("(4) um dem Kampf und Turm fliehen.");

         int choice = GameLogic.readInt("Bitte wähle eine Option aus: ", 4);

         switch (choice){
             case 1:
                 break;
             case 2:
                 usePotionInCombat(pc);
                 break;
             case 3:
                 changeWeaponInCombat(pc);
                 break;
             case 4:
                 break;
             default:

                 break;
         }

     }

     // Use Potion in Combat
     private static void usePotionInCombat(PlayerCharacter pc) {
         boolean validInput = false;
         do {
             try{
                 GameLogic.printSeperator(30);
                 CharacterInventory inventory = pc.getCharacterInventory();
                 inventory.showInventoryPotions();
                 int availableInventorySpace = inventory.getNumAvailableInventorySpace();
                 int itemPosition = GameLogic.readInt(
                         "Wähle einen Trank aus den: " + availableInventorySpace + " Inventarplätzen aus. \n" +
                                 "(0) wenn kein Trank verwendet werden soll und um zum Menü zurückzukehren",
                         availableInventorySpace);
                 // Use no Potion and go back to menu
                 if (itemPosition == 0){
                     System.out.println("Rückkehr zum Menü.");
                     GameLogic.printSeperator(30);
                     showIngameMenuInCombat(pc);
                     return; // back to menu
                 }
                 // Use Potion from inventory
                 inventory.useItemFromInventory(itemPosition, pc);
                 validInput = true;
             } catch (IllegalArgumentException e){
                 System.out.println("Ungülitge Eingabe. Bitte wähle eine gültige Position im Inventar");
             }
         } while (!validInput);
     }

     private static void changeWeaponInCombat(PlayerCharacter pc) {
         boolean validInput = false;
         CharacterClasses playerCharacterClass = pc.getCharacterClass().getCharacterClass();
         if (playerCharacterClass == CharacterClasses.WAFFENMEISTER) {
         do {
             try {
                 GameLogic.printSeperator(30);
                 CharacterInventory inventoryWeapons = pc.getCharacterInventory();
                 int availableWeaponSlots = inventoryWeapons.getNumAvailableWeaponInventorySpace();
                 inventoryWeapons.showInventoryWeapons();
                 int itemPosition = GameLogic.readInt(
                         "Wähle eine Waffe aus den " + availableWeaponSlots +
                                 " Waffenplätzen im Inventar eine zum Tausch aus. \n"
                                 + "(0) wenn keine Waffe getauscht werden soll und zum Menü zurückkehren.",
                         availableWeaponSlots);
                 // don't change weapon and go back to menu
                 if (itemPosition == 0) {
                     System.out.println("Rückkehr zum Menü.");
                     GameLogic.printSeperator(30);
                     showIngameMenuInCombat(pc);
                 }
                 // change corresponding weapon
                 inventoryWeapons.changeWeaponFromInventory(itemPosition, pc);
                 validInput = true;
             } catch (IllegalArgumentException e) {
                 System.out.println("Ungültige Eingabe. Bitte wähle eine gültige Position im Waffeninventar.");
             }

         } while (!validInput) ;
         } else if (playerCharacterClass == CharacterClasses.MAGIER){
             System.out.println("Magier können nur einen Zauberstab führen. Sie können die Waffe nicht wechseln. \n"
             + "Rückkehr zum Menü folgt.");
             GameLogic.printSeperator(30);
             showIngameMenuInCombat(pc);
     }
     }


 }
