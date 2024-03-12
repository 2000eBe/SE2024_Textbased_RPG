public abstract class Potion extends Items {
    private PotionType potionType;

    public Potion(String name, int price, PotionType potionType) {
        super(name, price);
        this.potionType = potionType;
    }

    public PotionType getPotionType() {
        return potionType;
    }

    public abstract void  usePotion(PlayerCharacter pc);

    public enum PotionType {
        HEALTH,
        MANA,
        STRENGTH,
        DEFENSE
        // Add more potion types as needed
    }
}