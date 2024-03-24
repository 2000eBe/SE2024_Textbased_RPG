import java.util.ArrayList;
import java.util.List;

// This class represents all the equipment item weapons that can be obtained and worn by the player
public class WeaponEquipment {


    private List<WeaponUpgrade> swordUpgrades;
    private List<WeaponUpgrade> axeUpgrades;
    private List<WeaponUpgrade> staffUpgrades;
    private List<WeaponUpgrade> maceUpgrades;


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

//TODO Change functionality to really get specifix Weapontype
    public List<WeaponUpgrade> getUpgradesForWeaponType(Weapon weapon){
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
}
