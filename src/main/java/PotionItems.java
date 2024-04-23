import java.util.Random;

// This is a class and collection of available items in the game that change the character statistics
public abstract class PotionItems {
    private String name;
    private int price;

    public PotionItems(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public static PotionItems getRandomPotion() {
        Random random = new Random();
        int roll = random.nextInt(100) +1;
        if (roll <= 50){
            return new HealthPotion();
        } else {
            return new ManaPotion();
        }
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


    // Potion implementations
    public static class HealthPotion extends PotionItems {
        public HealthPotion() {
            super("Heiltrank", 30);
        }

        @Override
        public void use(PlayerCharacter pc) {
            int maxHP;
            int currentHP = pc.getCurrentHP();
            if (pc.getCharacterClass().getCharacterClass() == CharacterClasses.WAFFENMEISTER){
                maxHP = 100;
            }
            else {
                maxHP = 75;
            }
            int healAmount = Math.min(maxHP - currentHP, 50);
            System.out.println("Du trinkst den Heiltrank und heilst dich um: " + healAmount);
            pc.heal(healAmount);
        }
    }


    public static class ManaPotion extends PotionItems {
        public ManaPotion() {
            super("Manatrank", 25);
        }

        public void use(PlayerCharacter pc) {
            int currentMP = pc.getCurrentMP();
            int maxMP = 100;
            int restoreAmount = Math.min(maxMP - currentMP, 75);
            System.out.println("Du trinkst einen Manatrank und stellst " + restoreAmount + " MP wieder her!");
            pc.restoreMP(restoreAmount);
        }

    }

    public static class AttackPotion extends PotionItems {
        public AttackPotion() {
            super("Trank der kritischen Angriffskraft", 100);
        }

        @Override
        public void use(PlayerCharacter pc) {
            System.out.println("Der Genuss dieses merkwürdigen Trankes macht dich blutrünstig! \n" +
                    "(Information: Der Trank erhöht dauerhaft deinen Kritischen Trefferwert um 5%!");
            pc.getCharacterInventory().getCurrentWeapon().getAttributes().setCritChance(0.2); // set to 20 %
        }

    }
}