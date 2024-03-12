import java.util.Arrays;

// This class is the character inventory which can hold different items at once
public class CharacterInventory {

    private final Weapon[] weaponInventory;
    private final Items[] itemInventory;
    private static final int MaxAvailableInventorySpace = 15;
    private static final int MaxWeaponArmorySpace = 3;

    private int currencyAmount;



    public CharacterInventory(){
        this.weaponInventory = new Weapon[MaxWeaponArmorySpace];
        this.itemInventory = new Items[MaxAvailableInventorySpace];
    }

    // Methods to add weapons or buffitems
    public void addWeaponToArmory(Weapon weapon, int position){
        if (position >= 0 && position < MaxWeaponArmorySpace){
            weaponInventory[position] = weapon;
        } else {
            throw new IllegalArgumentException("Ungültiger Ablageplatz für Waffe oder Inventar voll!");
        }
    }

    public void addBuffItemToInventory(Items buffItem, int position){
        if (position >= 0 && position < MaxAvailableInventorySpace){
            itemInventory[position] = buffItem;
        } else {
            throw new IllegalArgumentException("Ungültiger Ablageplatz für Item oder Inventar voll!");
        }
    }

   // Show contents of inventories
    public void showInventory(){
        System.out.println("Im Waffenschrank befinden sich folgende Waffen:");
        System.out.println(Arrays.toString(weaponInventory));
        System.out.println("Im Inventar befinden sich folgende Iteams");
        System.out.println(Arrays.toString(itemInventory));
    }


    // add Potion to inventory
    public void addPotion(Potion potion){
        for (int i = 0; i < itemInventory.length; i++){
            if (itemInventory[i] == null){
                itemInventory[i] = potion;
                break;
            }
        }
    }

    // take Potion out of inventory to use
    public void usePotionInInventory(int index, PlayerCharacter pc){
        if (index >= 0 && index < itemInventory.length && itemInventory[index] instanceof Potion){
            Potion potion = (Potion) itemInventory[index];
            potion.usePotion(pc);
            itemInventory[index] = null;
        } else {
            System.out.println("An dieser Stelle befindet sich kein Trank zum Konsumieren");
        }
    }

    // getter and setter

    public int getCurrencyAmount() {
        return currencyAmount;
    }

    public void setCurrencyAmount(int currencyAmount) {
        this.currencyAmount = currencyAmount;
    }
}
