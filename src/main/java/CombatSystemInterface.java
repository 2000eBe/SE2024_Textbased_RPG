public interface CombatSystemInterface {

    // Attack the NPC / Player with either magic or physical damage
    int attack();

    // Block a physical/magical attack
    int block();
    // Increase missing HP
    int heal();

}
