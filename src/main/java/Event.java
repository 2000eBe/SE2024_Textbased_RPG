import java.util.List;
import java.util.Random;

// This Class should represent special Events in the game, that can be triggered
public class Event {
    private final PlayerCharacter player;
    WeaponEquipment weaponEquipment;


    public Event(PlayerCharacter player){
        this.player = player;
        this.weaponEquipment = WeaponEquipment.getInstance();
    }
    public void spawnTreasureChest(){
        Random random = new Random();
        int roll = random.nextInt(100)+1; // roll between 1 and 100
        if (roll <= 50){
            // 50% chance to contain gold
            int goldAmount = random.nextInt(100)+1; // Gold amount between 1 and 100
            System.out.println("Du hast eine Goldtruhe mit " + goldAmount + " Gold gefunden und sammelst diese auf.");
            int currentGold = player.getCharacterInventory().getCurrencyAmount();
            player.getCharacterInventory().setCurrencyAmount(currentGold + goldAmount);
        } else {
            // 50% Chance to contain a potion
            PotionItems potion = PotionItems.getRandomPotion();
            System.out.println("Du hast eine Truhe mit " + potion + " gefunden und sammelst diese auf.");
            player.getCharacterInventory().addPotionItemToInventory(potion);
        }
    }

    // Makes last weaponUpgrade available
    public void spawnWeaponChest(){

        System.out.println("Die Marmorstatue zerbricht lässt einen Schlüsselbund und einen großen einzelnen Schlüssel fallen.");
        System.out.println("Du gehst damit durch die prächtige Tür und betrittst einen Ausstellungsraum.");
        System.out.println("Viele Vitrinen mit ausgestellten Waffen sind sichtbar. Der kleinere Schlüsselbund ist eindeutig für die Vitrinenschlösser");
        System.out.println("Sie sehen mächtiger aus als das, was die Waffenschmiede in der Stadt bieten kann!");
        System.out.println("Du öffnest die Vitrinen von den Waffen, die du tragen kannst, und nimmst sie an dich.");

        GameUtility.printSeperator(30);
        if (player.getCharacterClass().getCharacterClass() == CharacterClasses.WAFFENMEISTER){
            Weapon playerSword = player.getCharacterInventory().getWeaponAtIndex(0);
            Weapon playerAxe = player.getCharacterInventory().getWeaponAtIndex(1);
            Weapon playerMace = player.getCharacterInventory().getWeaponAtIndex(2);

            List<WeaponUpgrade> swords = weaponEquipment.getUpgradesForWeaponType(playerSword);
            List<WeaponUpgrade> axe = weaponEquipment.getUpgradesForWeaponType(playerAxe);
            List<WeaponUpgrade> mace = weaponEquipment.getUpgradesForWeaponType(playerMace);

            player.getCharacterInventory().getWeaponAtIndex(0).getAttributes().applyUpgrade(swords, swords.size()-1);
            player.getCharacterInventory().getWeaponAtIndex(1).getAttributes().applyUpgrade(axe, axe.size()-1);
            player.getCharacterInventory().getWeaponAtIndex(0).getAttributes().applyUpgrade(mace, mace.size()-1);
            System.out.println("Info: Du besitzt nun von dem Schwert, Axt und Streitkolben die höchste Stufe! ");

        } else {
            Weapon playerStaff = player.getCharacterInventory().getWeaponAtIndex(0);
            List<WeaponUpgrade> staff = weaponEquipment.getUpgradesForWeaponType(playerStaff);
            player.getCharacterInventory().getWeaponAtIndex(0).getAttributes().applyUpgrade(staff, staff.size()-1);
            System.out.println("Info: Du besitzt nun von dem Zauberstab die höchste Stufe! ");
        }
        weaponEquipment.setCanUpgrade(false); //make weapons not upgradeable anymore. Achieved highest weapon level
    }

    // SecretVendor that sells special potions
    public void spawnSecretVendor(){
        System.out.println("Es zieht dichter Nebel auf. Eine düstere geistähnliche Gestalt taucht auf und lächelt dich schelmisch an ");
        GameUtility.printSeperator(30);
        System.out.println("Düstere Gestalt:'' Danke, dass du mir den Weg freigemacht hast. Willst du einen Handel eingehen?" + "\n"
                            + "Ich biete dir einen mächtigen Trank der Angriffskraft für 20 Gold an...");
        System.out.println("(1) um den Trank zu kaufen.");
        System.out.println("(2) um den Handel abzulehnen. (Achtung: Der Händler zieht danach fort)");
        int input = GameUtility.readInt("-> ", 2);
        switch (input){
            case 1:
                System.out.println("Düstere Gestalt:'' Ahh... Eine gute Wahl junger " + player.getCharacterClass() + "! ''");
                buyPotionAtSecretVendor(new PotionItems.AttackPotion());
                break;
            case 2:
                System.out.println("Düstere Gestalt:'' Nun gut... Hoffentlich bereust du diese Entscheidung nicht...''");
                System.out.println("Die düstere Gestalt verschwindet im Nebel, der sich kurz darauf im Raum lichtet.");
                break;
            default:
                System.out.println("Ungültige Eingabe. Bitte versuche es erneut mit einer Zahl zwischen 1 und 2.");
        }
        GameUtility.printSeperator(30);
    }

    void buyPotionAtSecretVendor(PotionItems potion){
        int price = potion.getPrice();
        if (!player.getCharacterInventory().checkAffordable(price)){
            System.out.println("Düstere Gestalt:'' Du hast nicht genug Gold! Ich verschwinde!''");
            System.out.println("Die düstere Gestalt verschwindet schnell in der Dunkelheit. Der Nebel lichtet sich.''");
        } else if (player.getCharacterInventory().checkInventorySpace()) {
            System.out.println("Düstere Gestalt:'' Du scheinst keinen Platz im Inventar zu haben. Vielleicht sehen wir uns wieder...");
            System.out.println("Die düstere Gestalt verschwindet in der Dunkelheit. Der Nebel lichtet sich.''");
        } else {
            player.getCharacterInventory().payGold(price);
            player.getCharacterInventory().addPotionItemToInventory(potion);
            System.out.println("Du hast einen Trank der Kraft von der düsteren Gestalt erworben! Setze ihn weise ein.");
        }
    }
}
