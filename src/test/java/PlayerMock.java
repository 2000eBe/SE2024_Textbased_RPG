public class PlayerMock extends PlayerCharacter {

    public int damageTaken;
    public double curseTaken;
    public int healTaken;
    public boolean visitedInn = false;


    CharacterInventory inventory = new CharacterInventory(this);
    public PlayerMock(String playerName, CharacterClasses characterClass) {
        super(playerName, characterClass);
        inventory.setCurrencyAmount(100);
    }
    // get current HP
    public int getCurrentHP() {
        return 75;
    }

    @Override
    public int getMaxHP() {
        return 100;
    }

    public int getCurrentLevel() {
        return 5;
    }

    public int getCurrentMP() {
        return 100;
    }

    @Override
    public int getDefense() {

        return 0;
    }

    @Override
    public WeaponAttributes getWeaponAttribute() {
        return new WeaponAttributes(20,0);
    }

    // Getter and Setter Methods
    public CharacterInventory getCharacterInventory() {

    return inventory;
    }

    @Override
    public String getPlayerName() {
        return null;
    }


    public void setPlayerName(String playerName) {
    }


    @Override
    public int getAttacked(int amount, boolean alive) {
        damageTaken = amount;
        return 75;
    }

    // reduce MP for each magical skill usage
    @Override
    public int subtractMP(int amount) {
      return 0;
    }

    @Override
    public double curseDefense(double amount) {
        curseTaken = amount;
        return 5;
    }

    @Override
    public int heal(int amount) {
        healTaken = amount;
        return 0;
    }

    @Override
    public int getLevel() {
        return 0;
    }

    @Override
    // LevelSystem
    public void grantExp(int exp) {
    }

    @Override
    public void restoreMP(int restoreAmount) {

    }

    @Override
    public void restoreWithInn() {;
        visitedInn = true;
    }
}
