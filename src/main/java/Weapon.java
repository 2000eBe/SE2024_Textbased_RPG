import java.util.List;

public enum Weapon {
    ZAUBERSTAB("Zauberstab", new WeaponAttributes(10, 5)),
    SCHWERT("Schwert", new WeaponAttributes(15, 4)),
    AXT("Axt", new WeaponAttributes(20, 2)),
    STREITKOLBEN("Streitkolben", new WeaponAttributes(18, 3));

    private String weapontype;
    private WeaponAttributes attributes;
    private List<WeaponUpgrade> weaponUpgrades;

    Weapon(String weapontype, WeaponAttributes attributes) {
        this.weapontype = weapontype;
        this.attributes = attributes;
    }

    public String getWeapontype() {
        return weapontype;
    }

    public WeaponAttributes getAttributes() {
        return attributes;
    }

    public void setWeaponUpgrades(List<WeaponUpgrade> weaponUpgrades) {
        this.weaponUpgrades = weaponUpgrades;
    }
}
