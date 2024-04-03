import java.util.Random;

// This Class should represent special Events in the game, that can be triggered
public class Event {

    static PlayerCharacter pc;
    public void spawnTreasureChest(PlayerCharacter pc){
        Random random = new Random();
        int roll = random.nextInt(100)+1; // roll between 1 and 100
        if (roll <= 50){
            // 50% chance to contain gold
            int goldAmount = random.nextInt(100)+1; // Gold amount between 1 and 100
            System.out.println("Du hast eine Goldtruhe mit " + goldAmount + " Gold gefunden und sammelst diese auf.");
            int currentGold = pc.getCharacterInventory().getCurrencyAmount();
            pc.getCharacterInventory().setCurrencyAmount(currentGold + goldAmount);
        } else {
            // 50% Chance to contain a potion
            PotionItems potion = PotionItems.getRandomPotion();
            System.out.println("Du hast eine Truhe mit " + potion + " gefunden und sammelst diese auf.");
            pc.getCharacterInventory().addPotionItemToInventory(potion);
        }
    }

    // Makes last weaponUpgrade available
    public  void spawnWeaponChest(PlayerCharacter pc){
        // TODO Spawn Last Weapon Upgrade
    }

    // SecretVendor that sells special potions
    public void spawnSecretVendor(PlayerCharacter pc){
        System.out.println("Es zieht dichter Nebel auf. Eine düstere geistähnliche Gestalt taucht auf und lächelt dich schelmisch an ");
        GameLogic.printSeperator(30);
        System.out.println("Düstere Gestalt:'' Danke, dass du mir den Weg freigemacht hast. Willst du einen Handel eingehen?" + "\n"
                            + "Ich biete dir einen mächtigen Trank der Angriffskraft für 20 Gold an...");
        System.out.println("(1) um den Trank zu kaufen.");
        System.out.println("(2) um den Handel abzulehnen. (Achtung: Der Händler zieht danach fort)");
        int input = GameLogic.readInt("-> ", 2);
        switch (input){
            case 1:
                System.out.println("Düstere Gestalt:'' Ahh... Eine gute Wahl junger " + pc.getCharacterClass() + "! ''");
                buyPotionAtSecretVendor(new PotionItems.AttackPotion());
                break;
            case 2:
                System.out.println("Düstere Gestalt:'' Nun gut... Hoffentlich bereust du diese Entscheidung nicht...''");
                System.out.println("Die düstere Gestalt verschwindet im Nebel, der sich kurz darauf im Raum lichtet.");
                break;
            default:
                System.out.println("Ungültige Eingabe. Bitte versuche es erneut mit einer Zahl zwischen 1 und 2.");
        }
        GameLogic.printSeperator(30);
    }

    static void buyPotionAtSecretVendor(PotionItems potion){
        int price = potion.getPrice();
        if (!Shop.checkAffordable(price)){
            System.out.println("Düstere Gestalt:'' Du hast nicht genug Gold! Ich verschwinde!''");
            System.out.println("Die düstere Gestalt verschwindet schnell in der Dunkelheit. Der Nebel lichtet sich.''");
        } else if (!Shop.checkInventorySpace()) {
            System.out.println("Düstere Gestalt:'' Du scheinst keinen Platz im Inventar zu haben. Vielleicht sehen wir uns wieder...");
            System.out.println("Die düstere Gestalt verschwindet in der Dunkelheit. Der Nebel lichtet sich.''");
        } else {
            Shop.payGold(price);
            pc.getCharacterInventory().addPotionItemToInventory(potion);
            System.out.println("Du hast einen Trank der Kraft von der düsteren Gestalt erworben! Setze ihn weise ein.");
        }
    }
}
