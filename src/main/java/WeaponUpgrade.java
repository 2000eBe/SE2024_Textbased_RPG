public class WeaponUpgrade {
    private String upgradeName;
    private int price;

    private WeaponAttributes modifiedAttributes;


    public WeaponUpgrade(String upgradeName, int price, WeaponAttributes modifiedAttributes){
        this.upgradeName = upgradeName;
        this.price = price;
        this.modifiedAttributes = modifiedAttributes;

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
