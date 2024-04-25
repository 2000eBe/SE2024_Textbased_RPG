import java.util.Random;

public class Monster implements CombatInterface{

    private final String name;
    private final String description;
    private final int maxHP;
    private int level;
    private int hp;
    private final int minDmg;
    private final int maxDmg;
    private int defense;
    private static final Random rand = new Random();



    public Monster(String name, String description, int maxHP, int hp, int minDmg, int maxDmg, int defense, int level) {
        this.name = name;
        this.description = description;
        this.maxHP = maxHP;
        this.hp = hp;
        this.minDmg = minDmg;
        this.maxDmg = maxDmg;
        this.defense = defense;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }


    public int getAttacked(int amount, boolean defeated){
        int currentHP = getCurrentHP();
        if (currentHP > 0){
            currentHP -= amount;
            if (currentHP <= 0) {
                currentHP = 0; // Um sicherzustellen, dass HP nicht negativ wird
            }
            setHp(currentHP);
        }
        return currentHP;
    }

    @Override
    public int subtractMP(int amount) {
        return 0;
    }

    @Override
    public int attack() {
        // get random damage between minDmg and maxDmg
        int damage = rand.nextInt(this.maxDmg - this.minDmg + 1) + this.minDmg;
        return damage;
    }

    @Override
    public double curseDefense(double amount) {
        return this.defense = (int) Math.floor((this.defense*amount));
    }

    @Override
    public int getCurrentHP() {return this.hp;}

    @Override
    public int getMaxHP() {
        return this.maxHP;
    }

    @Override
    public int getCurrentMP() {
        return 0;
    }

    @Override
    public int getMaxMP() {
        return 0;
    }

    @Override
    public double getCritChance() {
        return 0;
    }


    @Override
    public int getBaseDamage() {
        return 0;
    }

    @Override
    public int getDefense() {
        return this.defense;
    }

    @Override
    public WeaponAttributes getWeaponAttribute() {
        return null;
    }

    @Override
    public int block() {
        return 0;
    }

    @Override
    public int heal(int damage) {
        return damage;
    }

    @Override
    // Getter & Setter for monster level
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }


}
