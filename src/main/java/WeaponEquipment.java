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
        maceUpgrades.add(new WeaponUpgrade("Streikolben Upgrade Stufe 1", 70));
        maceUpgrades.add(new WeaponUpgrade("Streikolben Upgrade Stufe 2", 120));
        maceUpgrades.add(new WeaponUpgrade("Streikolben Upgrade Stufe 3", 175));
        maceUpgrades.add(new WeaponUpgrade("Streikolben Upgrade Stufe 4", 200));
        maceUpgrades.add(new WeaponUpgrade("Streikolben Upgrade Stufe 5", 0)); // only obtainable in dungeon

    }

    private void initializeStaffUpgrades() {
        staffUpgrades.add(new WeaponUpgrade("Zauberstab Upgrade Stufe 1", 70));
        staffUpgrades.add(new WeaponUpgrade("Zauberstab Upgrade Stufe 2", 120));
        staffUpgrades.add(new WeaponUpgrade("Zauberstab Upgrade Stufe 3", 175));
        staffUpgrades.add(new WeaponUpgrade("Zauberstab Upgrade Stufe 4", 200));
        staffUpgrades.add(new WeaponUpgrade("Zauberstab Upgrade Stufe 5", 0)); // only obtainable in dungeon
    }

    private void initializeAxeUpgrades() {
    }

    private void initializeSwordUpgrades() {
    }


}
