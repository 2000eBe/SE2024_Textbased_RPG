public enum Weapon {
    ZAUBERSTAB("Zauberstab", new WeaponAttributes(10, 5)),
    SCHWERT("Schwert", new WeaponAttributes(15, 3)),
    AXT("Axt", new WeaponAttributes(20, 2)),
    STREITKOLBEN("Streitkolben", new WeaponAttributes(18, 4));

    private String weapontype;
    private WeaponAttributes attributes;

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
}
