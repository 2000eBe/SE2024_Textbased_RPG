import java.util.Arrays;

// This class is the character inventory which can hold different items at once
public class CharacterInventory {

    private final Weapon[] weaponInventory;
    private final PotionItems[] itemInventory;
    private static final int MaxAvailableInventorySpace = 4;
    private static final int MaxWeaponArmorySpace = 3;

    private int currencyAmount;



    public CharacterInventory(){
        this.weaponInventory = new Weapon[MaxWeaponArmorySpace];
        this.itemInventory = new PotionItems[MaxAvailableInventorySpace];
    }

    // Methods to add weapons or buffitems
    public void addWeaponToArmory(Weapon weapon, int position){
        if (position >= 0 && position < MaxWeaponArmorySpace){
            weaponInventory[position] = weapon;
        } else {
            throw new IllegalArgumentException("Ungültiger Ablageplatz für Waffe oder Inventar voll!");
        }
    }

    public void addPotionItemToInventory(PotionItems potion, int position){
        if (position >= 0 && position < MaxAvailableInventorySpace){
            itemInventory[position] = potion;
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


    // take Potion out of inventory to use
    public void useItemFromInventory(int position, PlayerCharacter player) {
        if (position >= 0 && position < MaxAvailableInventorySpace) {
            PotionItems item = itemInventory[position];
            if (item != null) {
                item.use(player);
                itemInventory[position] = null;
            } else {
                System.out.println("Kein Gegenstand an der angegebenen Position vorhanden.");
            }
        } else {
            throw new IllegalArgumentException("Ungültige Position im Inventar!");
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
