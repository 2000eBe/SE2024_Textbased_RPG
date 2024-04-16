import java.util.Random;

public class Monster implements CombatInterface{

    private final String name;
    private final String description;
    private final int maxHP;
    private int hp;
    private final int minDmg;
    private final int maxDmg;
    private int defense;
    private boolean aggression;
    private static final Random rand = new Random();



    public Monster(String name, String description, int maxHP, int hp, int minDmg, int maxDmg, int defense, boolean aggression) {
        this.name = name;
        this.description = description;
        this.maxHP = maxHP;
        this.hp = hp;
        this.minDmg = minDmg;
        this.maxDmg = maxDmg;
        this.defense = defense;
        this.aggression = aggression;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMinDmg() {
        return minDmg;
    }

    public int getMaxDmg() {
        return maxDmg;
    }

    public boolean isAggression() {
        return aggression;
    }

    public void setAggression(boolean aggression) {
        this.aggression = aggression;
    }
    public static Object randomMonster() {
        return null;
    }



    public int getAttacked(int amount){
        int currentHP = getCurrentHP();
        if (currentHP > 0){
            currentHP -= amount;
            if (currentHP <= 0) {
                currentHP = 0; // Um sicherzustellen, dass HP nicht negativ wird
                CombatSystem.monsterGotDefeated(this);
            }
            setHp(currentHP);
        }
        return currentHP;
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
    public Weapon getEquippedWeapon() {
        return null;
    }

    @Override
    public int attack() {
        return 0;
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
    public int getLevel() {
        return 0;
    }


}
