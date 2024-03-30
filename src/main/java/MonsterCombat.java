public interface MonsterCombat {

    // Return the monster's current HP

    int getCurrentHP();


    // Return the monster's max HP

    int getMaxHP();


    // Return the monster's base damage

    int getBaseDamage();


    // Return the monster's defense

    int getDefense();


    // Apply damage to the monster

    void heal(int damage);
}
