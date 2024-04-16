public class Attack {
    private final CombatInterface attacker;
    private final CombatInterface defender;
    private final int damage;
    private final boolean isCritical;


    public Attack(CombatInterface attacker, CombatInterface defender, int damage, boolean isCritical) {
        this.attacker = attacker;
        this.defender = defender;
        this.damage = damage;
        this.isCritical = isCritical;

    }


    // Getter methods
    public CombatInterface getAttacker() {
        return attacker;
    }

    public CombatInterface getDefender() {
        return defender;
    }

    public int getDamage() {
        return damage;
    }

    public boolean isCritical() {
        return isCritical;
    }
}
