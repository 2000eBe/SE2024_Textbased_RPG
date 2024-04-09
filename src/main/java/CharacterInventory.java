import java.util.Arrays;

// This class is the character inventory which can hold different items at once
public class CharacterInventory {

    private final Weapon[] weaponInventory;
    private final PotionItems[] itemInventory;
    private static final int MaxAvailableInventorySpace = 4;
    private static final int MaxWeaponArmorySpace = 3;

    private int currencyAmount;
    private Weapon currentWeapon;



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

    public void addPotionItemToInventory(PotionItems potion){
        boolean added = false;
        for (int i = 0; i < MaxAvailableInventorySpace; i++){
            if(itemInventory[i] == null){
                itemInventory[i] = potion;
                added = true;
                break;
            }
        }
        if (!added) {
            throw new IllegalArgumentException("Inventar voll! Du kannst nichts mehr aufnehmen oder kaufen!");
        }

    }

   // Show contents of inventories
    public void showInventoryWeapons(){
        System.out.println("Im Waffenschrank befinden sich folgende Waffen:");
        System.out.println(Arrays.toString(weaponInventory));
    }

    public void showInventoryPotions(){
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

    public Weapon getCurrentWeapon(){
        return currentWeapon;
    }

    public void setCurrentWeapon(Weapon weapon){
        if (Arrays.asList(weaponInventory).contains(weapon)){
            currentWeapon = weapon;
        } else {
            throw new IllegalArgumentException("Die Waffe ist im Waffenschrank nicht vorhanden!");
        }

    }

    public int getCurrencyAmount() {
        return currencyAmount;
    }

    public void setCurrencyAmount(int currencyAmount) {
        this.currencyAmount = currencyAmount;
    }

    // check for available Inventory space
    public int getNumAvailableInventorySpace() {
        int count = 0;
        for(PotionItems item : itemInventory){
            if (item == null){
                count++;
            }
        }
        return count;
    }
}
