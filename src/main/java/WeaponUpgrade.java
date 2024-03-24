public class WeaponUpgrade {
    private String upgradeName;
    private int price;

    public WeaponUpgrade(String upgradeName, int price){
        this.upgradeName = upgradeName;
        this.price = price;
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
}
