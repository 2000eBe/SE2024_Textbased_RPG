// This is a class and collection of available items in the game that change the character statistics
public class Items {
    private int price;
    private Weapon weaponType;

    Items(String name, int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void use(PlayerCharacter pc) {
    }



 /*
    // Health Potion
    public class HealthPotion extends Items {
        private HealthPotion() {
            super(50, );
        }

        public void use(PlayerCharacter pc){
            int currentHP = pc.getCurrentHP();
            int maxHP = pc.getCharacterClass().getHp();
            int healAmount = Math.min(maxHP - currentHP, 50);
            pc.heal(healAmount);
        }

    }

    // Mana Potion

    public class ManaPotion extends Items {
        private ManaPotion(int price) {
            super(75, null);
        }
        public void use(PlayerCharacter pc){
            int currentMP = pc.getCurrentMP();
            int maxMP = pc.getCharacterClass().getMp();
            int restoreAmount = Math.min(maxMP - currentMP, 75);
            pc.restoreMP(restoreAmount);
        }

    }

    // Weapon Upgrades

    public class WeaponUpgrade extends Items {

        private Weapon weapon;
        public WeaponUpgrade(int price, Weapon weapon) {
            super(price, weaponType);
            this.weapon = weapon;
        }

       public void use(PlayerCharacter pc){

        }

        }
        */

}