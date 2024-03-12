import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// This class is the character inventory which can hold different items at once
public class CharacterInventory {

    private final Weapon[] weaponInventory;
    private final BuffItems[] buffitemInventory;
    private static final int MaxAvailableInventorySpace = 15;
    private static final int MaxWeaponArmorySpace = 3;

    private int currencyAmount;



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

   // Show contents of inventories
    public void showInventory(){
        System.out.println("Im Waffenschrank befinden sich folgende Waffen:");
        System.out.println(Arrays.toString(weaponInventory));
        System.out.println("Im Inventar befinden sich folgende Iteams");
        System.out.println(Arrays.toString(buffitemInventory));
    }


    // getter and setter

    public int getCurrencyAmount() {
        return currencyAmount;
    }

    public void setCurrencyAmount(int currencyAmount) {
        this.currencyAmount = currencyAmount;
    }
}
