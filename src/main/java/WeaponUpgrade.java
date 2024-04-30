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

    // Getter & Setter
    public String getUpgradeName() {
        return upgradeName;
    }

    public int getPrice() {
        return price;
    }

    public WeaponAttributes getModifiedAttributes() {
        return modifiedAttributes;
    }

}
