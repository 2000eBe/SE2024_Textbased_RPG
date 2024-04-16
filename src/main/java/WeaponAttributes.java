public class WeaponAttributes {

    private int baseAttackPoints;
    private int baseCritPoints;

    public WeaponAttributes(int baseAttackPoints, int baseCritPoints){
        this.baseAttackPoints = baseAttackPoints;
        this.baseCritPoints = baseCritPoints;

    }

    // Getter and Setter
    public int getBaseAttackPoints() {
        return baseAttackPoints;
    }

    public void setBaseAttackPoints(int baseAttackPoints) {
        this.baseAttackPoints = baseAttackPoints;
    }

    public int getBaseCritPoints() {
        return baseCritPoints;
    }

    public void setBaseCritPoints(int baseCritPoints) {
        this.baseCritPoints = baseCritPoints;
    }

    public double getCritChance() {
        return 0.15; //15 % Crit Chance
    }
}
