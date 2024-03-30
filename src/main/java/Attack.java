public class Attack {
    private final PlayerCombat attacker;
    private final PlayerCombat defender;
    private final int damage;
    private final boolean isCritical;


    public Attack(PlayerCombat attacker, PlayerCombat defender, int damage, boolean isCritical) {
        this.attacker = attacker;
        this.defender = defender;
        this.damage = damage;
        this.isCritical = isCritical;

    }


    // Getter methods
    public PlayerCombat getAttacker() {
        return attacker;
    }

    public PlayerCombat getDefender() {
        return defender;
    }

    public int getDamage() {
        return damage;
    }

    public boolean isCritical() {
        return isCritical;
    }
}
