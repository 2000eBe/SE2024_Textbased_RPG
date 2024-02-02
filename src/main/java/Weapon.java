public enum Weapon {
    ZAUBERSTAB("Zauberstab"),
    SCHWERT("Schwert"),
    AXT("Axt"),
    STREITKOLBEN("Streitkolben");

    private String weapontype;
    Weapon(String weapontype) {
        this.weapontype = weapontype;
    }

    public String getWeapontype(){
        return weapontype;
    }
}

