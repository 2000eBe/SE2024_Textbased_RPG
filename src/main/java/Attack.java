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

}
