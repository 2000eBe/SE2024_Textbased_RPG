import java.util.ArrayList;
import java.util.List;

// This class is the character inventory which can hold different items at once
public class CharacterInventory {

    private Weapon[] weaponInventory;
    private BuffItems[] buffitemInventory;
    private static int MaxAvailableInventorySpace = 15;
    private static int MaxWeaponArmorySpace = 3;


    public CharacterInventory(){
        this.weaponInventory = new Weapon[MaxWeaponArmorySpace];
        this.buffitemInventory = new BuffItems[MaxAvailableInventorySpace];
    }

    // Methods to add weapons or buffitems
    public void addWeaponToArmory(Weapon weapon, int position){
        if (position >= 0 && position < MaxWeaponArmorySpace){
            weaponInventory[position] = weapon;
        } else {
            throw new IllegalArgumentException("Ungültiger Ablageplatz für Waffe oder Inventar voll!");
        }
    }

    public void addBuffItemToInventory( BuffItems buffItem, int position){
        if (position >= 0 && position < MaxAvailableInventorySpace){
            buffitemInventory[position] = buffItem;
        } else {
            throw new IllegalArgumentException("Ungültiger Ablageplatz für Item oder Inventar voll!");
        }
    }

}
