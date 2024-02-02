// This class should identify the chosen class (magical, physical Warrior) of the player and give it specific traits
public class CharacterClass {


    private CharacterClasses characterClass;
    private Weapon weapon; // Type of Weapons
    private int hp; // health points
    private int mp; // mana points

    public void Magier( int hp, int mp, Weapon weapon){
        this.characterClass = CharacterClasses.MAGIER;
        this.hp = hp;
        this.mp = 100; // only mages need mana points

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

    public void Waffenmeister(int hp, Weapon weapon){
        this.characterClass = CharacterClasses.WAFFENMEISTER;
        this.hp = hp;

    }






}
