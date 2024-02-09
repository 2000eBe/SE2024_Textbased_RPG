import java.util.Random;

public class Monster implements CombatSystemInterface{

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

    @Override
    public int attack() {
        return rand.nextInt(maxDmg - minDmg - 1 );
    }

    @Override
    public int block() {
        return 0;
    }

    @Override
    public int heal() {
        return 0;
    }


}
