public interface CombatInterface {

    // Amout of Damage that gets deducted from hp
    int getAttacked(int amount, boolean alive);

    // reduce MP for each magical skill usage
    int subtractMP(int amount);

    double curseDefense(double amount);

    // Combatsystem
    int attack();

    // Increase missing HP
    int heal(int amount);

    // Return the attacker's level
    int getLevel();

    // Return the attacker's current HP
    int getCurrentHP();


    // Return the attacker's max HP
    int getMaxHP();


    // Return the attacker's current MP
    int getCurrentMP();

    // Return the attacker's defense
    int getDefense();

    WeaponAttributes getWeaponAttribute();

}
