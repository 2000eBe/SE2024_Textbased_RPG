import java.util.Random;

public class Monster implements MonsterCombat{

    private final String name;
    private final String description;
    private final int maxHP;
    private int hp;
    private final int minDmg;
    private final int maxDmg;
    private final int defense;
    private final double critChance;
    private boolean aggression;
    private static final Random rand = new Random();


    public Monster(String name, String description, int maxHP, int hp, int minDmg, int maxDmg, int defense, double critChance, boolean aggression) {
        this.name = name;
        this.description = description;
        this.maxHP = maxHP;
        this.hp = hp;
        this.minDmg = minDmg;
        this.maxDmg = maxDmg;
        this.defense = defense;
        this.critChance = critChance;
        this.aggression = aggression;
    }

    public static Object randomMonster() {
        return null;
    }



    @Override
    public int getCurrentHP() {
        return 0;
    }

    @Override
    public int getMaxHP() {
        return 0;
    }


    @Override
    public int getBaseDamage() {
        return 0;
    }

    @Override
    public int getDefense() {
        return 0;
    }

    @Override
    public void heal(int damage) {

    }


}
