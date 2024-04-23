import java.util.List;

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

    public void applyUpgrade(List<WeaponUpgrade> upgrades, int index){
        int test1 = this.baseAttackPoints;
        int test2 = this.baseCritPoints;
        //System.out.println("DEBUG alte BASEATTACKPOINTS: " + test1);
        //System.out.println("DEBUG alte BASECRITPOINTS " + test2);
        if (!upgrades.isEmpty()){
            WeaponUpgrade upgrade = upgrades.get(index); // erstes Upgrade aus der Liste auswählen
           // System.out.println("BaseAttack Points aus neuem Upgrade:" + upgrade.getModifiedAttributes().getBaseAttackPoints());
           // System.out.println("BaseCrit Points a. n. U.:" + upgrade.getModifiedAttributes().getBaseCritPoints());
            this.baseAttackPoints = upgrade.getModifiedAttributes().getBaseAttackPoints();
            this.baseCritPoints = upgrade.getModifiedAttributes().getBaseCritPoints();
        } else {
            System.out.println("Die Waffe ist nicht weiter upgradebar.");
        }
        //System.out.println("DEBUG neue BASEATTACKPOINTS: " + this.baseAttackPoints);
        //System.out.println("DEBUG neue BASECRITPOINTS " + this.baseCritPoints);
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
