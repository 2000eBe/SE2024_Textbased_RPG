import java.util.ArrayList;
import java.util.List;

// This class represents all the equipment item weapons that can be obtained and worn by the player
public class WeaponEquipment {


    private static List<WeaponUpgrade> swordUpgrades;
    private static List<WeaponUpgrade> axeUpgrades;
    private static List<WeaponUpgrade> staffUpgrades;
    private static List<WeaponUpgrade> maceUpgrades;


    public WeaponEquipment(){
        // initialize lists for upgrades
        swordUpgrades = new ArrayList<>();
        axeUpgrades = new ArrayList<>();
        staffUpgrades = new ArrayList<>();
        maceUpgrades = new ArrayList<>();

        initializeSwordUpgrades();
        initializeAxeUpgrades();
        initializeStaffUpgrades();
        initalizeMaceUpgrades();

    }



    // Methods to Initialize Weaponupgrades for every type of weapon
    private void initalizeMaceUpgrades() {
        maceUpgrades.add(new WeaponUpgrade("Streitkolben Upgrade Stufe 1", 70, new WeaponAttributes(20, 5)));
        maceUpgrades.add(new WeaponUpgrade("Streitkolben Upgrade Stufe 2", 120, new WeaponAttributes(25, 7)));
        maceUpgrades.add(new WeaponUpgrade("Streitkolben Upgrade Stufe 3", 175, new WeaponAttributes(30, 10)));
        maceUpgrades.add(new WeaponUpgrade("Streitkolben Upgrade Stufe 4", 200, new WeaponAttributes(35, 12)));
        maceUpgrades.add(new WeaponUpgrade("Streitkolben Upgrade Stufe 5", 0, new WeaponAttributes(40, 15))); // only obtainable in dungeon

    }

    private void initializeStaffUpgrades() {
        staffUpgrades.add(new WeaponUpgrade("Zauberstab Upgrade Stufe 1", 70, new WeaponAttributes(10, 5)));
        staffUpgrades.add(new WeaponUpgrade("Zauberstab Upgrade Stufe 2", 120, new WeaponAttributes(15, 7)));
        staffUpgrades.add(new WeaponUpgrade("Zauberstab Upgrade Stufe 3", 175, new WeaponAttributes(20, 10)));
        staffUpgrades.add(new WeaponUpgrade("Zauberstab Upgrade Stufe 4", 200, new WeaponAttributes(25, 12)));
        staffUpgrades.add(new WeaponUpgrade("Zauberstab Upgrade Stufe 5", 0, new WeaponAttributes(30, 18))); // only obtainable in dungeon
    }

    private void initializeAxeUpgrades() {
        axeUpgrades.add(new WeaponUpgrade("Axt Upgrade Stufe 1", 70, new WeaponAttributes(22, 6)));
        axeUpgrades.add(new WeaponUpgrade("Axt Upgrade Stufe 2", 120, new WeaponAttributes(25, 8)));
        axeUpgrades.add(new WeaponUpgrade("Axt Upgrade Stufe 3", 175, new WeaponAttributes(35, 10)));
        axeUpgrades.add(new WeaponUpgrade("Axt Upgrade Stufe 4", 200, new WeaponAttributes(38, 12)));
        axeUpgrades.add(new WeaponUpgrade("Axt Upgrade Stufe 5", 0, new WeaponAttributes(42, 14))); // only obtainable in dungeon
    }

    private void initializeSwordUpgrades() {
        swordUpgrades.add(new WeaponUpgrade("Schwert Upgrade Stufe 1", 70, new WeaponAttributes(20, 7)));
        swordUpgrades.add(new WeaponUpgrade("Schwert Upgrade Stufe 2", 120, new WeaponAttributes(24, 9)));
        swordUpgrades.add(new WeaponUpgrade("Schwert Upgrade Stufe 3", 175, new WeaponAttributes(28, 10)));
        swordUpgrades.add(new WeaponUpgrade("Schwert Upgrade Stufe 4", 200, new WeaponAttributes(35, 14)));
        swordUpgrades.add(new WeaponUpgrade("Schwert Upgrade Stufe 5", 0, new WeaponAttributes(38, 17))); // only obtainable in dungeon
    }


    public static List<WeaponUpgrade> getSwordUpgrades() {return swordUpgrades;}

    public static List<WeaponUpgrade> getAxeUpgrades() {
        return axeUpgrades;
    }

    public static List<WeaponUpgrade> getStaffUpgrades() {
        return staffUpgrades;
    }

    public static List<WeaponUpgrade> getMaceUpgrades() {
        return maceUpgrades;
    }

//TODO Change functionality to really get specific Weapontype
    public static List<WeaponUpgrade> getUpgradesForWeaponType(Weapon weapon){
        switch (weapon.getWeapontype()){
            case "Schwert":
                return swordUpgrades;
            case "Axt":
                return axeUpgrades;
            case "Zauberstab":
                return staffUpgrades;
            case "Streitkolben":
                return maceUpgrades;
            default:
                throw new IllegalArgumentException("Ungültiger Waffentyp");

        }
    }

    public static void setStarterWeapons(PlayerCharacter pc){
        CharacterClasses playerClass = pc.getCharacterClass().getCharacterClass();

        if (playerClass == CharacterClasses.WAFFENMEISTER){

            Weapon sword = Weapon.SCHWERT;
            Weapon axe = Weapon.AXT;
            Weapon mace = Weapon.STREITKOLBEN;
            List<WeaponUpgrade> swordUpgrades = getUpgradesForWeaponType(sword);
            List<WeaponUpgrade> axeUpgrades = getUpgradesForWeaponType(axe);
            List<WeaponUpgrade> maceUpgrades = getUpgradesForWeaponType(mace);

            sword.setWeaponUpgrades(swordUpgrades);
            axe.setWeaponUpgrades(axeUpgrades);
            mace.setWeaponUpgrades(maceUpgrades);

            //CharacterInventory inventory = new CharacterInventory(pc); fml alter was habe ich mir hier gedacht
            CharacterInventory inventory = pc.getCharacterInventory();

            inventory.addWeaponToArmory(sword, 0); //add standard sword to armory
            inventory.addWeaponToArmory(axe, 1); //add standard mace to armory
            inventory.addWeaponToArmory(mace, 2); //add standard axe to armory
            inventory.setCurrentWeapon(sword);

        } else if (playerClass == CharacterClasses.MAGIER){
            // Mages can only wear the staff, so only one weapon is initialized
            Weapon staff = Weapon.ZAUBERSTAB;
            List<WeaponUpgrade> staffUpgrades = getUpgradesForWeaponType(staff);
            staff.setWeaponUpgrades(staffUpgrades);

            //CharacterInventory inventory = new CharacterInventory(pc);
            CharacterInventory inventory = pc.getCharacterInventory();
            inventory.addWeaponToArmory(staff, 0);
            inventory.setCurrentWeapon(staff);
        }
    }

}
