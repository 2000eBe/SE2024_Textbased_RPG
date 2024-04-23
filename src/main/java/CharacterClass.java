// This class should identify the chosen class (magical, physical Warrior) of the player and give it specific traits
public class CharacterClass {


    private CharacterClasses characterClass;
    private Weapon weapon; // Type of Weapons
    private int hp; // health points
    private int mp; // mana points

    public void Magier( int hp, int mp, Weapon weapon){
        this.characterClass = CharacterClasses.MAGIER;
        this.hp = 75;
        this.mp = 100; // only mages need mana points
        this.weapon = weapon;

    }

    public void changeWeapon(){
        if(characterClass == CharacterClasses.MAGIER){
            // check if player can wield the weapon
            if (weapon == Weapon.ZAUBERSTAB){
                this.weapon = weapon;
            } else {
                throw new IllegalArgumentException("Magier können nur Zauberstäbe führen.");
            }
        }

        if (characterClass == CharacterClasses.WAFFENMEISTER){
            // check if player can wield the weapon
            if (weapon == Weapon.SCHWERT || weapon == Weapon.STREITKOLBEN ||weapon == Weapon.AXT ){
                this.weapon = weapon;
            } else {
                throw new IllegalArgumentException("Krieger können keine Zauberstäbe führen.");
            }
        }

    }

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

    public void Waffenmeister(int hp, Weapon weapon){
        this.characterClass = CharacterClasses.WAFFENMEISTER;
        this.hp = hp;

    }


    public String toString(){
        if (characterClass == CharacterClasses.MAGIER) {
            return "Magier";
        } else if (characterClass == CharacterClasses.WAFFENMEISTER) {
            return "Waffenmeister";
        } else {
            return "Unbekannt"; // Behandeln Sie den Fall, wenn die Klasse nicht festgelegt ist
        }
    }



}
