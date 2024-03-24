// This is a class and collection of available items in the game that change the character statistics
public abstract class PotionItems {
    private String name;
    private int price;

    public PotionItems(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String toString(){
        return getName();
    }

    public abstract void use(PlayerCharacter pc);

    public class HealthPotion extends PotionItems {
        public HealthPotion() {
            super("Heiltrank", 50);
        }

        @Override
        public void use(PlayerCharacter pc) {
            int currentHP = pc.getCurrentHP();
            int maxHP = pc.getCharacterClass().getHp();
            int healAmount = Math.min(maxHP - currentHP, 50);
            pc.heal(healAmount);
        }
    }


    public class ManaPotion extends PotionItems {
        public ManaPotion() {
            super("Manatrank", 35);
        }


        public void use(PlayerCharacter pc) {
            int currentMP = pc.getCurrentMP();
            int maxMP = pc.getCharacterClass().getMp();
            int restoreAmount = Math.min(maxMP - currentMP, 75);
            pc.restoreMP(restoreAmount);


        }

    }
}