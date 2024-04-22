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

    public static class HealthPotion extends PotionItems {
        public HealthPotion() {
            super("Heiltrank", 30);
        }

        @Override
        public void use(PlayerCharacter pc) {
            int currentHP = pc.getCurrentHP();
            int maxHP = pc.getCharacterClass().getHp();
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
            int maxMP = pc.getCharacterClass().getMp();
            int restoreAmount = Math.min(maxMP - currentMP, 75);
            pc.restoreMP(restoreAmount);


        }

    }

    public static class AttackPotion extends PotionItems {
        public AttackPotion() {
            super("Trank der Angriffskraft", 20);
        }

        @Override
        public void use(PlayerCharacter pc) {
            // TODO Write Code to interact with combat / weapon stats
        }
    }
}