import java.util.List;

// This class implements a new player character and its traits
public class PlayerCharacter implements CombatInterface {

    private CharacterClass characterClass = new CharacterClass();
    private PlayerCharacter pc;
    private CharacterInventory characterInventory;
    private String playerName;
    private int currentLevel;
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
        this.weaponEquipment = new WeaponEquipment();


    }




    // Method to choose the charactername
    public void CharacterCreationName(){
        // GameLogic.printHeading("Charaktererstellung");
        boolean nameSet = false;

        do {
            System.out.println("Wie heißt du? ");
            setPlayerName(GameLogic.scanner.nextLine());
            GameLogic.printHeading("Den Namen " + getPlayerName() + " bestätigen?");
            System.out.println("(1) für ''Ja''");
            System.out.println("(2) für ''Nein, ich möchte mich gerne umbenennen!''");

            int input = GameLogic.readInt("-> ", 2);
            if (input == 1){
                nameSet = true;
            } else if (input == 2) {
                System.out.println("Bitte den korrigierten Namen eintragen.");

            }
        } while (!nameSet);
    }

   // Method to choose the characterclass
   public void CharacterCreationClass() {
       boolean classSet = false;
       do {
           GameLogic.printSeperator(30);
           System.out.println("Welche Klasse möchtest du spielen?" + "\n" + "Magier oder Waffenmeister?");
           System.out.println("Du kannst deine Klasse danach nicht mehr ändern!");
           System.out.println("(1) für ''Magier''");
           System.out.println("(2) für ''Waffenmeister''");
           System.out.println("(3) für Informationen zu den beiden Klassen");

           int input = GameLogic.readInt("-> ", 3);

           if (input == 1) {
               System.out.println("Entscheidest du dich für den Pfad der Magie?" + "\n" +
                       "(1) für ''Ja''!" + "\n" +
                       "(2) für ''Nein, ich möchte es mir erneut überlegen''"
               );
               int input1 = GameLogic.readInt("-> ", 2);
               if (input1 == 1) {
                   characterClass.setCharacterClass(CharacterClasses.MAGIER);
                   classSet = true;
                   characterInventory.setCurrencyAmount(50);
                   WeaponEquipment.setStarterWeapons(this);
               }
           } else if (input == 2) {
               System.out.println("Entscheidest du dich für den Pfad der Waffenkunst?" + "\n" +
                       "(1) für ''Ja''!" + "\n" +
                       "(2) für ''Nein, ich möchte es mir erneut überlegen''"
               );
               int input1 = GameLogic.readInt("-> ", 2);
               if (input1 == 1) {
                   characterClass.setCharacterClass(CharacterClasses.WAFFENMEISTER);

                   classSet = true;
                   characterInventory.setCurrencyAmount(50);
                   WeaponEquipment.setStarterWeapons(this);
               }
           } else if (input == 3) {
               GameLogic.printSeperator(30);
               System.out.println(
                       "Magier haben weniger Lebenspunkte als Waffenmeister. Sie haben jedoch Manapunkte und ihre " + "\n" +
                               "Angriffe sind mächtiger - dafür sind sie umso gebrechlicher. Magier können nur Zauberstäbe führen.");
               System.out.println(
                       "Waffenmeister haben mehr Lebenspunkte und keine Manapunkte." + "\n" +
                               "Sie können Schwerter, Äxte und Streitkolben führen, aber keine Zauberstäbe." + "\n" +
                               "Ihre Angriffe sind stark abhängig von der geführten Waffe.");
               GameLogic.printSeperator(30);
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
        return 0;
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
    public int getAttacked(int amount) {
        return 0;
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
        if (characterClass.getCharacterClass() == CharacterClasses.MAGIER) {
            maxHP = 75;
        }
        int currentHP = characterClass.getHp();
        currentHP += amount;
        if(currentHP > maxHP){
            currentHP = maxHP;
        }

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
           int maxMP = characterClass.getMp();

            int currentMP = getCurrentMP();
            if(currentMP > maxMP){
                currentMP = maxMP;
            }
        }
        System.out.println("Manatränke haben keinen Effekt auf Waffenmeister");
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int level) {
        this.currentLevel = level;
    }

    public Map getCurrentDungeon() {
        return null;
    }

    public void setCurrentDungeon(Dungeon dungeon) {
        this.currentDungeon = dungeon;
    }

    // Methode zur Anzeige und Auswahl von Fähigkeiten
    public void displayAndChooseAbility() {
        List<Ability> availableAbilities = AbilityFactory.getAvailableAbilities(characterClass.getCharacterClass(), getCurrentLevel());
        System.out.println("Verfügbare Fähigkeiten:");
        int abilityNumber = 1;
        for (Ability ability : availableAbilities) {
            System.out.println("(" + abilityNumber + ") " + ability.getName() + ": " + ability.getDescription());
            abilityNumber++;
        }
        // Hier kann der Spieler eine Fähigkeit auswählen und entsprechende Aktionen ausführen
    }
}

