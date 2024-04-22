public interface CombatInterface {

    // Amout of Damage that gets deducted from hp
    int getAttacked(int amount, boolean alive);


    double curseDefense(double amount);
    // Combatsystem
    int attack();

    // Block a physical/magical attack
    int block();

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


    // Return the attacker's max MP
    int getMaxMP();


    // Return the attacker's critical hit chance
    double getCritChance();


    // Return the attacker's base damage
    int getBaseDamage();

    // Return the attacker's defense
    int getDefense();

    Weapon getEquippedWeapon();
}
