import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// This class represents all the equipment item weapons that can be obtained and worn by the player
public class WeaponEquipment {
    private static final WeaponEquipment INSTANCE = new WeaponEquipment();

    private HashMap<Weapon,List<WeaponUpgrade>> weaponUpgradeLists;

    private Boolean canUpgrade;

    public static WeaponEquipment getInstance(){
        return INSTANCE;
    }
    public  void setCanUpgrade(boolean b) {
        canUpgrade = b;
    }

    public  Boolean getCanUpgrade() {
        return canUpgrade;
    }

    private WeaponEquipment(){
        weaponUpgradeLists = new HashMap<>();
        weaponUpgradeLists.put(Weapon.SCHWERT, initializeSwordUpgrades());
        weaponUpgradeLists.put(Weapon.AXT, initializeAxeUpgrades());
        weaponUpgradeLists.put(Weapon.ZAUBERSTAB, initializeStaffUpgrades());
        weaponUpgradeLists.put(Weapon.STREITKOLBEN, initializeMaceUpgrades());
        setCanUpgrade(true);
    }



    // Methods to Initialize Weaponupgrades for every type of weapon
    private List<WeaponUpgrade> initializeMaceUpgrades() {
        List<WeaponUpgrade> maceUpgrades = new ArrayList<>();
        maceUpgrades.add(
                new WeaponUpgrade("Streitkolben Stufe 1", 70,
                        new WeaponAttributes(20, 5)));
        maceUpgrades.add(
                new WeaponUpgrade("Streitkolben Stufe 2", 120,
                        new WeaponAttributes(25, 7)));
        maceUpgrades.add(
                new WeaponUpgrade("Streitkolben Stufe 3", 175,
                        new WeaponAttributes(30, 10)));
        maceUpgrades.add(
                new WeaponUpgrade("Streitkolben Stufe 4", 200,
                        new WeaponAttributes(35, 12)));
        maceUpgrades.add(
                new WeaponUpgrade("Streitkolben Stufe 5", 0,
                        new WeaponAttributes(40, 15))); // only obtainable in dungeon
        return maceUpgrades;
    }

    private List<WeaponUpgrade> initializeStaffUpgrades() {
        List<WeaponUpgrade> staffUpgrades = new ArrayList<>();
        staffUpgrades.add(
                new WeaponUpgrade(
                "Zauberstab Stufe 1", 70,
                    new WeaponAttributes(10, 5)));
        staffUpgrades.add(
                new WeaponUpgrade(
                "Zauberstab Stufe 2", 120,
                    new WeaponAttributes(15, 7)));
        staffUpgrades.add(
                new WeaponUpgrade(
                "Zauberstab Stufe 3", 175,
                    new WeaponAttributes(20, 10)));
        staffUpgrades.add(
                new WeaponUpgrade(
                "Zauberstab Stufe 4", 200,
                        new WeaponAttributes(25, 12)));
        staffUpgrades.add(new WeaponUpgrade(
                "Zauberstab Stufe 5", 0,
                    new WeaponAttributes(30, 18))); // only obtainable in dungeon
        return staffUpgrades;
    }

    private List<WeaponUpgrade> initializeAxeUpgrades() {
        List<WeaponUpgrade> axeUpgrades = new ArrayList<>();
        axeUpgrades.add(
                new WeaponUpgrade(
                "Axt Stufe 1", 70,
                    new WeaponAttributes(22, 6)));
        axeUpgrades.add(
                new WeaponUpgrade(
                "Axt Stufe 2", 120,
                    new WeaponAttributes(25, 8)));
        axeUpgrades.add(
                new WeaponUpgrade(
                "Axt Stufe 3", 175,
                    new WeaponAttributes(35, 10)));
        axeUpgrades.add(
                new WeaponUpgrade(
                "Axt Stufe 4", 200,
                        new WeaponAttributes(38, 12)));
        axeUpgrades.add(
                new WeaponUpgrade(
                "Axt Stufe 5", 0,
                    new WeaponAttributes(42, 14))); // only obtainable in dungeon
        return axeUpgrades;
    }

    private List<WeaponUpgrade> initializeSwordUpgrades() {
        List<WeaponUpgrade> swordUpgrades = new ArrayList<>();
        swordUpgrades.add(
                new WeaponUpgrade(
                        "Schwert Stufe 1", 70,
                        new WeaponAttributes(20, 7)));
        swordUpgrades.add(
                new WeaponUpgrade("Schwert Stufe 2", 120,
                    new WeaponAttributes(24, 9)));
        swordUpgrades.add(
                new WeaponUpgrade("Schwert Stufe 3", 175,
                        new WeaponAttributes(28, 10)));
        swordUpgrades.add(
                new WeaponUpgrade("Schwert Stufe 4", 200,
                        new WeaponAttributes(35, 14)));
        swordUpgrades.add(
                new WeaponUpgrade("Schwert Stufe 5", 0,
                        new WeaponAttributes(38, 17))); // only obtainable in dungeon
        return swordUpgrades;
    }


    //get each specific List of Upgrades
    public List<WeaponUpgrade> getUpgradesForWeaponType(Weapon weapon){
        switch (weapon.getWeapontypeName()){
            case "Schwert":
                return weaponUpgradeLists.get(Weapon.SCHWERT);
            case "Axt":
                return weaponUpgradeLists.get(Weapon.AXT);
            case "Zauberstab":
                return weaponUpgradeLists.get(Weapon.ZAUBERSTAB);
            case "Streitkolben":
                return weaponUpgradeLists.get(Weapon.STREITKOLBEN);
            default:
                throw new IllegalArgumentException("Ungültiger Waffentyp");

        }
    }

    public void showAvailableUpgradesForWeapon(Weapon weapon, PlayerCharacter player){
        List<WeaponUpgrade> availableUpgrades = getUpgradesForWeaponType(weapon);


        if (canUpgrade)
        {
            System.out.println("Verfügbare Upgrades für " + weapon.getWeapontypeName() + ":");
            System.out.println("Information: Du kannst deine Waffe nur nach der Reihe verbessern. " +
                    "Du kannst nicht direkt die höchste Stufe erwerben!");

            while (!availableUpgrades.isEmpty()) {
                // Anzeige der verfügbaren Upgrades
                for (int i = 0; i < availableUpgrades.size()-2; i++){
                    WeaponUpgrade upgrade = availableUpgrades.get(i);
                    System.out.println("(" + (i+1) + ") " + upgrade.getUpgradeName() + " (Kosten " + upgrade.getPrice() + ")" +
                            " mit Werten: Angriffspunkte: " + upgrade.getModifiedAttributes().getBaseAttackPoints() +
                            " & Kritische Trefferpunkte: " + upgrade.getModifiedAttributes().getBaseCritPoints());
                }

                GameUtility.printSeperator(30);
                System.out.println("Möchtest du eine Waffenverbesserung erwerben?");
                System.out.println("(1) für Ja");
                System.out.println("(2) um zurück zum Sortiment zu gehen.");
                int input = GameUtility.readInt("->", 2);

                if (input == 1){
                    // Finde den Index des niedrigsten verfügbaren Upgrades
                    int selectedIndex = 0;
                    WeaponUpgrade lowestUpgrade = availableUpgrades.get(0);
                    for (int i = 1; i < availableUpgrades.size()-2; i++) {
                        WeaponUpgrade currentUpgrade = availableUpgrades.get(i);
                        if (currentUpgrade.getPrice() < lowestUpgrade.getPrice()) {
                            lowestUpgrade = currentUpgrade;
                            selectedIndex = i;
                        }
                    }

                    WeaponUpgrade selectedUpgrade = availableUpgrades.get(selectedIndex);
                    int weaponPrice = selectedUpgrade.getPrice();

                    if (!player.getCharacterInventory().checkAffordable(weaponPrice)){
                        System.out.println("Du kannst dir die Verbesserung nicht leisten! ");
                        GameUtility.printSeperator(30);
                    } else {
                        System.out.println("Waffe wurde geupgraded!");
                        player.getCharacterInventory().payGold(weaponPrice);
                        weapon.getAttributes().applyUpgrade(availableUpgrades, selectedIndex);
                       availableUpgrades.remove(selectedUpgrade);
                    }
                    return;
                } else if (input == 2){
                    System.out.println("Du kehrst zurück");
                    return;
                }
            }
        } else if(!canUpgrade){
            System.out.println("Waffenhändler:'' So eine mächtige Waffe, wie du sie führst, habe ich noch nicht gesehen! \n" +
                    "Ich kann dir keine bessere Waffe schmieden...''");
            System.out.println("Der Waffenschmied schickt dich fort");
            GameUtility.printSeperator(30);
            return;
        }

    }



    public  void setStarterWeapons(PlayerCharacter pc){
        CharacterClasses playerClass = pc.getCharacterClass().getCharacterClass();

        if (playerClass == CharacterClasses.WAFFENMEISTER){

            Weapon sword = Weapon.SCHWERT;
            Weapon axe = Weapon.AXT;
            Weapon mace = Weapon.STREITKOLBEN;

            List<WeaponUpgrade> swordUpgrades = getUpgradesForWeaponType(sword);
            swordUpgrades.add(getUpgradesForWeaponType(sword).get(0));
            List<WeaponUpgrade> axeUpgrades = getUpgradesForWeaponType(axe);
            axeUpgrades.add(getUpgradesForWeaponType(axe).get(0));
            List<WeaponUpgrade> maceUpgrades = getUpgradesForWeaponType(mace);
            maceUpgrades.add(getUpgradesForWeaponType(mace).get(0));

            sword.setWeaponUpgrades(swordUpgrades);
            axe.setWeaponUpgrades(axeUpgrades);
            mace.setWeaponUpgrades(maceUpgrades);

            CharacterInventory inventory = pc.getCharacterInventory();

            inventory.addWeaponToArmory(sword, 0); //add standard sword to armory
            inventory.addWeaponToArmory(axe, 1); //add standard mace to armory
            inventory.addWeaponToArmory(mace, 2); //add standard axe to armory
            inventory.setCurrentWeapon(sword);

        } else if (playerClass == CharacterClasses.MAGIER){
            // Mages can only wear the staff, so only one weapon is initialized
            Weapon staff = Weapon.ZAUBERSTAB;
            List<WeaponUpgrade> staffUpgrades = getUpgradesForWeaponType(staff);
            staffUpgrades.add(getUpgradesForWeaponType(staff).get(0));
            staff.setWeaponUpgrades(staffUpgrades);

            CharacterInventory inventory = pc.getCharacterInventory();
            inventory.addWeaponToArmory(staff, 0);
            inventory.setCurrentWeapon(staff);
        }
    }


}
