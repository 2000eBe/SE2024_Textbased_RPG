// This class should identify the chosen class (magical, physical Warrior) of the player and give it specific traits
public class CharacterClass {

    private CharacterClasses characterClass;
    private Weapon weapon; // Type of Weapons
    private int hp; // health points
    private int mp; // mana points

    public void setCharacterClass(CharacterClasses characterClass) {
        this.characterClass = characterClass;
        setHp(100);
        setMp(0);
        setWeapon(Weapon.SCHWERT);
        if (characterClass == CharacterClasses.MAGIER){
            setHp(75);
            setMp(100); // only mages have MP
            setWeapon(Weapon.ZAUBERSTAB);
        }
    }
    public String toString(){
        if (characterClass == CharacterClasses.MAGIER) {
            return "Magier";
        } else if (characterClass == CharacterClasses.WAFFENMEISTER) {
            return "Waffenmeister";
        } else {
            return "Unbekannt"; // if not available
        }
    }

    public CharacterClasses getCharacterClass() {
        return characterClass;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public int getHp() {
        return this.hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }





}
