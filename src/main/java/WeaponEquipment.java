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

        initalizeSwordUpgrades();
        initializeAxeUpgrades();
        initializeStaffUpgrades();
        initalizeMaceUpgrades();

    }

    // Methods to Initialize Weaponupgrades for every type of weapon
    private void initalizeMaceUpgrades() {
    }

    private void initializeStaffUpgrades() {
    }

    private void initializeAxeUpgrades() {
    }

    private void initalizeSwordUpgrades() {
    }


}
