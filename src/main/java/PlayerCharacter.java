import java.util.List;

// This class implements a new player character and its traits
public class PlayerCharacter implements CombatInterface {

    private CharacterClass characterClass = new CharacterClass();
    private PlayerCharacter pc;
    private CharacterInventory characterInventory;
    private String playerName;

    private Dungeon currentDungeon;
    private LevelSystem level;
    private List<Ability> abilities;
    private WeaponEquipment weaponEquipment;
    public int defense = 15;


    public PlayerCharacter(String playerName, CharacterClasses characterClass){
        this.playerName = playerName;
        this.characterClass.setCharacterClass(characterClass);
        this.level = new LevelSystem(1);
        this.characterInventory = new CharacterInventory(this);
        this.weaponEquipment = new WeaponEquipment(this);


    }

    // Method to choose the charactername
    public void CharacterCreationName(){
        // GameUtility.printHeading("Charaktererstellung");
        boolean nameSet = false;

        do {
            System.out.println("Wie heißt du? ");
            setPlayerName(GameUtility.nextLine());
            GameUtility.printHeading("Den Namen " + getPlayerName() + " bestätigen?");
            System.out.println("(1) für ''Ja''");
            System.out.println("(2) für ''Nein, ich möchte mich gerne umbenennen!''");

            int input = GameUtility.readInt("-> ", 2);
            if (input == 1){
                nameSet = true;
            } else if (input == 2) {
                String line;
                System.out.println("Bitte neuen Namen eingeben: ");
                do {
                    line = GameUtility.nextLine();
                } while (line.isEmpty());
                setPlayerName(line);
                nameSet = true;
            }
        } while (!nameSet);
    }

   // Method to choose the characterclass
   public void CharacterCreationClass() {
       boolean classSet = false;
       do {
           GameUtility.printSeperator(30);
           System.out.println("Welche Klasse möchtest du spielen?" + "\n" + "Magier oder Waffenmeister?");
           System.out.println("Du kannst deine Klasse danach nicht mehr ändern!");
           System.out.println("(1) für ''Magier''");
           System.out.println("(2) für ''Waffenmeister''");
           System.out.println("(3) für Informationen zu den beiden Klassen");

           int input = GameUtility.readInt("-> ", 3);

           if (input == 1) {
               System.out.println("Entscheidest du dich für den Pfad der Magie?" + "\n" +
                       "(1) für ''Ja''!" + "\n" +
                       "(2) für ''Nein, ich möchte es mir erneut überlegen''"
               );
               int input1 = GameUtility.readInt("-> ", 2);
               if (input1 == 1) {
                   characterClass.setCharacterClass(CharacterClasses.MAGIER);
                   classSet = true;
                   characterInventory.setCurrencyAmount(100);
                   WeaponEquipment.setStarterWeapons(this);
               }
           } else if (input == 2) {
               System.out.println("Entscheidest du dich für den Pfad der Waffenkunst?" + "\n" +
                       "(1) für ''Ja''!" + "\n" +
                       "(2) für ''Nein, ich möchte es mir erneut überlegen''"
               );
               int input1 = GameUtility.readInt("-> ", 2);
               if (input1 == 1) {
                   characterClass.setCharacterClass(CharacterClasses.WAFFENMEISTER);

                   classSet = true;
                   characterInventory.setCurrencyAmount(100);
                   WeaponEquipment.setStarterWeapons(this);
               }
           } else if (input == 3) {
               GameUtility.printSeperator(30);
               System.out.println(
                       "Magier haben weniger Lebenspunkte als Waffenmeister. Sie haben jedoch Manapunkte und ihre " + "\n" +
                               "Angriffe sind mächtiger - dafür sind sie umso gebrechlicher. Magier können nur Zauberstäbe führen.");
               System.out.println(
                       "Waffenmeister haben mehr Lebenspunkte und keine Manapunkte." + "\n" +
                               "Sie können Schwerter, Äxte und Streitkolben führen, aber keine Zauberstäbe." + "\n" +
                               "Ihre Angriffe sind stark abhängig von der geführten Waffe.");
               GameUtility.printSeperator(30);
           }
       } while (!classSet);
   }

// get current HP
   public int getCurrentHP(){
       int currentHP = characterClass.getHp();
       return currentHP;
    }

    @Override
    public int getMaxHP() {
        if (this.characterClass.getCharacterClass() == CharacterClasses.MAGIER){
            return 75;
        } else {
            return 100;
        }

    }

    public int getCurrentMP(){
        int currentMP = characterClass.getMp();
        return currentMP;
    }

    @Override
    public int getMaxMP() {
        return 0;
    }

    @Override
    public double getCritChance() {
        return 0;
    }

    @Override
    public int getBaseDamage() {
        return 0;
    }

    @Override
    public int getDefense() {
        return 0;
    }

    @Override
    public Weapon getEquippedWeapon() {
        if (characterInventory.getCurrentWeapon() != null){
            return characterInventory.getCurrentWeapon();
        }
        return null;
    }



    // Getter and Setter Methods

        public CharacterInventory getCharacterInventory() {
            return characterInventory;
        }

        public void setCharacterInventory(CharacterInventory characterInventory) {this.characterInventory = characterInventory;}

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public String getPlayerName() {
            return playerName;
        }

        public CharacterClass getCharacterClass() {return characterClass;}
        public void setCharacterClass() {}
        public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }


    @Override
    public int getAttacked(int amount, boolean alive) {
        int currentHP = getCurrentHP();
        //System.out.println("HP vor Angriff" + currentHP); DEBUG
        currentHP -= amount;
        if (currentHP < 0){
            currentHP = 0;
        }
        // System.out.println("HP NACH Angriff" + currentHP); DEBUG
        this.characterClass.setHp(currentHP);
        return currentHP;
    }

    // reduce MP for each magical skill usage
    @Override
    public int subtractMP(int amount) {
        int currentMP = getCurrentMP();
            currentMP -= amount;
            this.characterClass.setMp(currentMP);
            return currentMP;
    }
    @Override
    public double curseDefense(double amount) {
        return this.defense = (int) Math.floor(this.defense * amount);
    }

    // Combatsystem
    @Override
    public int attack() {
        return 0;
    }

    @Override
    public int block() {
        return 0;
    }

    @Override
    public int heal(int amount) {

        int maxHP = 100;
        if (this.characterClass.getCharacterClass() == CharacterClasses.MAGIER) {
            maxHP = 75;
            int currentHP = this.getCurrentHP();
            currentHP += amount;
            if(currentHP > maxHP){
                this.characterClass.setHp(maxHP);
            }
            this.characterClass.setHp(currentHP);
        }

        int currentHP = this.getCurrentHP();
        currentHP += amount;
        if(currentHP > maxHP){
           this.characterClass.setHp(maxHP);
        }
        this.characterClass.setHp(currentHP);
        return maxHP;

    }

    @Override
    public int getLevel() {
        return 0;
    }

    // LevelSystem
    public void grantExp(int exp){
        level.addExp(exp);
    }

    public void restoreMP(int restoreAmount) {
        if (characterClass.getCharacterClass() == CharacterClasses.MAGIER) {
           int maxMP = 100;
            int currentMP = this.getCurrentMP();
            currentMP += restoreAmount;
            if(currentMP > maxMP){
                currentMP = maxMP;
                this.characterClass.setHp(currentMP);
            }
            this.characterClass.setMp(currentMP);
        } else {
            System.out.println("Manatränke haben keinen Effekt auf Waffenmeister, " +
                    "da sie keine MP besitzen");
        }
    }

    public void restoreWithInn(){
        if (characterClass.getCharacterClass() == CharacterClasses.MAGIER) {
            this.characterClass.setMp(100); //reset MP to fullest
            this.heal(15);
            System.out.println("Du hast volle MP und deine HP hat sich um den Wert 15 erholt!");
        } else if (characterClass.getCharacterClass() == CharacterClasses.WAFFENMEISTER){
            this.heal(15);
            System.out.println("Deine HP hat sich um den Wert 15 erholt!");
        }
    }

    public int getCurrentLevel() {
        return level.getCurrentLevel();
    }

    public void setCurrentLevel(int level) {
        ;
    }

    public Map getCurrentDungeon() {
        return null;
    }

    public void setCurrentDungeon(Dungeon dungeon) {
        this.currentDungeon = dungeon;
    }

}

