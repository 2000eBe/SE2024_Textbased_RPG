import java.util.List;

public class WeaponUpgrade {
    private String upgradeName;
    private int price;

    private WeaponAttributes modifiedAttributes;


    public WeaponUpgrade(String upgradeName, int price, WeaponAttributes modifiedAttributes){
        this.upgradeName = upgradeName;
        this.price = price;
        this.modifiedAttributes = modifiedAttributes;

    }


    public  void upgradeWeapon(){
        // Check if upgrade available for next level
        if (this.upgradeName.endsWith("Stufe 5")){
            System.out.println("Es gibt keine mächtigere Waffe als diese im ganzen Land!");
            return;
        }

        //get current level of the weapon
        int currentUpgradeLevel = getCurrentUpgradeLevel();

        /* get weapon type with name
        Zum Beispiel, wenn upgradeName "Schwert Upgrade Stufe 1" ist, dann wird split(" ")
        diesen String in die Teile "Schwert", "Upgrade", "Stufe", "1" aufteilen, und [0]
        würde "Schwert" zurückgeben, was der Basistyp ist.
         */
        String baseName = upgradeName.split(" ")[0];

        // Name for the next Upgrade
        String nextUpgradeName = baseName + " Upgrade Stufe " + (currentUpgradeLevel + 1);

        // Search next available weapon upgrade in the weapon list

        List<WeaponUpgrade> upgrades = getUpgradeList();
        for (WeaponUpgrade upgrade : upgrades){
            if (upgrade.getUpgradeName().equals(nextUpgradeName)){
                this.upgradeName = upgrade.getUpgradeName();
                this.price = upgrade.getPrice();
                this.modifiedAttributes = upgrade.getModifiedAttributes();
                System.out.println("Waffe erfolgreich aufgerüstet auf " + upgrade.getUpgradeName());
                return;
            }
        }


    }

    private List<WeaponUpgrade> getUpgradeList() {
        // TODO
        return WeaponEquipment.getSwordUpgrades();
    }

    private int getCurrentUpgradeLevel() {
        String[] parts = upgradeName.split(" ");
        return Integer.parseInt(parts[parts.length -1]);
    }

    // Getter & Setter
    public String getUpgradeName() {
        return upgradeName;
    }

    public void setUpgradeName(String upgradeName) {
        this.upgradeName = upgradeName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public WeaponAttributes getModifiedAttributes() {
        return modifiedAttributes;
    }

    public void setModifiedAttributes(WeaponAttributes modifiedAttributes) {
        this.modifiedAttributes = modifiedAttributes;
    }
}
