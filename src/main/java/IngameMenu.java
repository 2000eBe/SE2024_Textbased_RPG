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
                         "Wähle einen Trank aus dem Inventar aus: " + availableInventorySpace + "\n" +
                                 "(0) wenn kein Trank verwendet werden soll und um zum Menü zurückzukehren",
                         availableInventorySpace);
                 // Use no Potion and go back to menu
                 if (itemPosition == 0){
                     System.out.println("Rückkehr zum Menü");
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
     }


 }
