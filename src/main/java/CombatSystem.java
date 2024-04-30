import java.util.List;

// This Class implements a textbased combat system
public class CombatSystem {
    private final IngameMenu ingameMenu;
    private final Event event;

    public static boolean weaponChestGotTriggered;

    private boolean merchantGotTriggered = false;



    Dungeon dungeon;
    PlayerCharacter player;
    Monster monster;


    public CombatSystem(PlayerCharacter player) {
        this.player = player;
        ingameMenu = new IngameMenu(player);
        event = new Event(player);
        setWeaponChestGotTriggered(false);
    }

    public void setDungeon(Dungeon d) {
        dungeon = d;
    }

    public void setMonster(Monster m) {
        monster = m;
    }

    public boolean startCombatRound(PlayerCharacter player, List<Monster> monsters) {
        while (player.getCurrentHP() > 0 && areMonstersAlive(monsters)) {
            for (Monster monster : monsters) {
                setMonster(monster);
                if (monster.getCurrentHP() <= 0) {
                    continue;
                }
                // Player gets to attack
                boolean b = playerAttackMonster();
                if (!b) {
                    return false;
                }
                if (player.getCurrentHP() <= 0) {
                    playerGotDefeated();
                    return false; // End combat if player is defeated
                }

            }
            // Monsters get to attack
            if (player.getCurrentHP() > 0) {
                for (Monster monster : monsters) {
                    if (monster.getCurrentHP() <= 0) {
                        continue; // skip any defeated monsters
                    }
                    monsterAttackPlayer();
                    if (player.getCurrentHP() <= 0) {
                        playerGotDefeated();
                        return false; // End Combat if player is defeated
                    }
                }
            }

        }
        return continueGameAfterCombat();
    }

    private boolean continueGameAfterCombat() {
        GameUtility.printSeperator(30);
        System.out.println("Herzlichen Glückwunsch! Du hast alle Gefahren der Etage gemeistert");
        if (GameLogic.isTowerPlayable){
        double random = Math.random();
        if (random < 0.4) {
            event.spawnTreasureChest();
        }

        if (dungeon.getLevel().isBossArea() && !getWeaponChestGotTriggered()){
            event.spawnWeaponChest();
            setWeaponChestGotTriggered(true);
        } // Weapons spawn on the first boss throughout the game and only once

        if (!merchantGotTriggered && random < 0.3){
            event.spawnSecretVendor();
            merchantGotTriggered = true;
        }
        }

        dungeon.increaseLevel();
        do {
            System.out.println("Was möchtest du nun tun?");
            System.out.println("(1) um die nächste Turm-Etage zu erklimmen.");
            System.out.println("(2) um das Menü für den Kampf & Sonstiges zu öffnen.");
            System.out.println("(3) um den Turm zu verlassen und zum Hauptmenü zurückzukehren (Turm-Etage bleibt erhalten).");
            int input = GameUtility.readInt("-> ", 3);
            switch (input) {
                case 1:
                    return true;
                case 2:
                    ingameMenu.showIngameMenuInCombat();
                    break;
                case 3:
                    return false;
            }
        } while (true);
    }

    private void showCurrentMonsterHP() {
        int countMonster = 1;
        int currentHP = monster.getCurrentHP();
        System.out.println(monster.getName() + " " + countMonster + " hat noch " + currentHP + " HP übrig!");
    }

    private void showCurrentPlayerHPandMP() {
        if (player.getCharacterClass().getCharacterClass() == CharacterClasses.MAGIER) {
            System.out.println("Aktueller Stand:"
                    + player.getCurrentHP() + "/" + 75 + " HP & "
                    + player.getCurrentMP() + "/" + 100 + " MP");
        } else {
            System.out.println("Aktueller Stand:"
                    + player.getCurrentHP() + "/" + 100 + " HP");
        }
    }


    public void monsterGotDefeated(Monster monster) {
        int expGained = dungeon.calculateExpForLevel(monster.getLevel());
        System.out.println(monster.getName() + " wurde bezwungen!");
        System.out.println("Du erhälst " + expGained + " EXP!");
        player.grantExp(expGained);
    }

    private void playerGotDefeated() {
        System.out.println("Du wurdest bezwungen!");
        System.out.println(
                "Du kehrst zum Hauptmenü zurück und" +
                        " bereitest dich auf die erneute Exkursion vor." +
                        " (Bezwungene Turm-Etagen bleiben erhalten!");
    }

    public boolean playerAttackMonster() {
        List<Ability> availableAbilities = AbilityFactory.getAvailableAbilities(
                player.getCharacterClass().getCharacterClass(),
                player.getCurrentLevel());
        do {
        GameUtility.printSeperator(30);
        System.out.println("Verfügbare Fähigkeiten: ");
        for (int iterator = 0; iterator < availableAbilities.size(); iterator++) {
            Ability ability = availableAbilities.get(iterator);
            System.out.println("(" + (iterator + 1) + ") " + ability.getName() + ": " + ability.getDescription());
        }
        System.out.println("(" + (availableAbilities.size() + 1) + ") für Kampfmenü (sonstiges)");

            int input = GameUtility.readInt("-> ", availableAbilities.size() + 1);
            if (input >= 1 && input <= availableAbilities.size()) {
                Ability selectedAbility = availableAbilities.get(input - 1);
                System.out.println("Du hast " + selectedAbility.getName() + " ausgewählt!");
                Ability.executeAbility(selectedAbility.getName(), player, monster);
                showCurrentMonsterHP();
                if (monster.getCurrentHP() <= 0) {
                    monsterGotDefeated(monster);
                }
                return true;
            } else if (input == availableAbilities.size() + 1) {
                if (!ingameMenu.showIngameMenuInCombat()){
                    return false;
                }
            }
        } while (true);
    }

    public void monsterAttackPlayer() {
        double defenseFromPlayer = ((double) player.getDefense() / 100);
        double blockChance = Math.random();
        int damage = monster.attack();
        if (!(blockChance < defenseFromPlayer)) {
            System.out.println(monster.getName() + " greift an und verursacht " + damage + " Schaden!");
            player.getAttacked(damage, true);
            showCurrentPlayerHPandMP();
        } else {
            System.out.println("Du hast den Angriff geblockt!");
        }


    }
    /*

    public Attack executeAttack(CombatInterface attacker, CombatInterface defender) {
        // Execute attack for the player
        if(attacker instanceof PlayerCharacter){
            PlayerCharacter pc = (PlayerCharacter) attacker;
            List<Ability> availableAbilities = AbilityFactory.getAvailableAbilities(pc.getCharacterClass().getCharacterClass(), pc.getCurrentLevel());
            GameUtility.printSeperator(30);
            System.out.println("Verfügbare Fähigkeiten: ");
            for (int iterator = 0; iterator < availableAbilities.size(); iterator++) {
                Ability ability = availableAbilities.get(iterator);
                System.out.println("(" + (iterator + 1) + ") " + ability.getName() + ": " + ability.getDescription());
            }
            System.out.println("(" + (availableAbilities.size() +1) + ") für Kampfmenü (sonstiges)");

            int input = GameUtility.readInt("-> ", availableAbilities.size() +1);
            if(input >=1 && input <= availableAbilities.size()){
                Ability selectedAbility = availableAbilities.get(input -1);
                System.out.println("Du hast " + selectedAbility.getName() + " ausgewählt!");
                Ability.executeAbility(selectedAbility.getName(), attacker, defender);
                showCurrentMonsterHP((Monster) defender);
                if (defender.getCurrentHP() <= 0){
                    monsterGotDefeated((Monster) defender);
                }
            } else if (input == availableAbilities.size() + 1){
                ingameMenu.showIngameMenuInCombat();
            }

        } // Execute Attack for the monster
        else if (attacker instanceof  Monster){
            Monster monster = (Monster) attacker;
            double defenseFromPlayer = (defender.getDefense()/100);
            double blockChance = Math.random();
            int damage = monster.attack();
            if (!(blockChance < defenseFromPlayer)){
                System.out.println(monster.getName() + " greift an und verursacht " + damage + " Schaden!");
                defender.getAttacked(damage, true);
                ShowCurrentPlayerHPandMP((PlayerCharacter) defender);
            } else {
                System.out.println("Du hast den Angriff geblockt!");
            }
        }
        return null;
    }
    */

    private static boolean areMonstersAlive(List<Monster> monsters) {
        for (Monster monster : monsters) {
            if (monster.getCurrentHP() > 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean getWeaponChestGotTriggered() {
        return weaponChestGotTriggered;
    }

    public static void setWeaponChestGotTriggered(boolean weaponChestGotTriggered) {
        CombatSystem.weaponChestGotTriggered = weaponChestGotTriggered;
    }

}
