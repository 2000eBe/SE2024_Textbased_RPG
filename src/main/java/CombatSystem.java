import java.util.Random;
import java.util.List;

// This Class implements a textbased combat system that is similar to the old Final Fantasy Games or Pokémon
public class CombatSystem {
    static Dungeon dungeon;
    static PlayerCharacter player;
    public static void startCombatRound(PlayerCharacter player, List<Monster> monsters){
        while (player.getCurrentHP() > 0 && areMonstersAlive(monsters)) {
            for (Monster monster : monsters) {
                // Player gets to attack
                executeAttack(player, monster);
                if (monster.getCurrentHP() <= 0) {
                    monsterGotDefeated(monster);
                }
                if (player.getCurrentHP() <= 0) {
                    playerGotDefeated(player);
                    return; // End combat if player is defeated
                }
            }

            // Monsters get to attack
            if (player.getCurrentHP() > 0){
                for (Monster monster: monsters){
                    if(monster.getCurrentHP() <= 0 ){
                        continue; // skip any defeated monsters
                    }
                    executeAttack(monster, player);
                    if (player.getCurrentHP() <= 0){
                        playerGotDefeated(player);
                        return; // End Combat if player is defeated
                    }
                }
            }
        }
        if(!areMonstersAlive(monsters)){
            GameLogic.printSeperator(30);
            System.out.println("Herzlichen Glückwunsch! Du hast alle Gefahren der Etage gemeistert");
            double random = Math.random();
            if (random < 0.4){
                Event.spawnTreasureChest(player);
            }

            System.out.println("Was möchtest du nun tun?");
            System.out.println("(1) um die nächste Turm-Etage zu erklimmen.");
            System.out.println("(2) um das Menü für den Kampf & Sonstiges zu öffnen.");
            System.out.println("(3) um den Turm zu verlassen und zum Hauptmenü zurückzukehren (Turm-Etage bleibt erhalten).");
            int input = GameLogic.readInt("-> ", 3);
            switch (input){
                case 1:
                    //TODO next Level
                    break;
                case 2:
                    IngameMenu.showIngameMenuInCombat(player);
                    break;
                case 3:
                    GameLogic.showMainMenu();
                    // TODO Etage als Verweis irgendwo speichern
            }

        }
    }


    public static void monsterGotDefeated(Monster monster) {
        System.out.println(monster.getName() + " wurde bezwungen!");
        int expGained = dungeon.calculateExpForLevel(monster.getLevel());
        player.grantExp(expGained);
        System.out.println("Du erhälst " + expGained + " EXP!");
    }

    private static void playerGotDefeated(PlayerCharacter player) {
        System.out.println("Du wurdest bezwungen!");
        System.out.println("(1) um zum Hauptmenü zurückzukehren und sich auf die erneute Exkursion vorzubereiten (Bezwungene Turm-Etagen bleiben erhalten!");
        System.out.println("(2) um die Turm-Etage erneut zu versuchen");
        System.out.println("Treffe eine Entscheidung!");
        int input = GameLogic.readInt("-> ", 2);
        if(input == 1){
            GameLogic.printSeperator(30);
            GameLogic.showMainMenu();
        } else if (input == 2) {
            //TODO Level zurücksetzen
        }
    }


    public static Attack executeAttack(CombatInterface attacker, CombatInterface defender) {
        if(attacker instanceof PlayerCharacter){
            PlayerCharacter pc = (PlayerCharacter) attacker;
            List<Ability> availableAbilities = AbilityFactory.getAvailableAbilities(pc.getCharacterClass().getCharacterClass(), pc.getCurrentLevel());
            GameLogic.printSeperator(30);
            System.out.println("Verfügbare Fähigkeiten: ");
            for (int iterator = 0; iterator < availableAbilities.size(); iterator++) {
                Ability ability = availableAbilities.get(iterator);
                System.out.println((iterator + 1) + ". " + ability.getName() + ": " + ability.getDescription());
            }
            System.out.println("(" + (availableAbilities.size() +1) + ") für Kampfmenü (sonstiges)");

            int input = GameLogic.readInt("-> ", availableAbilities.size() +1);
            if(input >=1 && input <= availableAbilities.size()){
                Ability selectedAbility = availableAbilities.get(input -1);
                System.out.println("Du hast " + selectedAbility.getName() + " ausgewählt!");
                Ability.executeAbility(selectedAbility.getName(), attacker, defender);
            } else if (input == availableAbilities.size() + 1){
                IngameMenu.showIngameMenuInCombat(pc);
            }

        } else if (attacker instanceof  Monster){
            Monster monster = (Monster) attacker;
            double defenseFromPlayer = (defender.getDefense()/100);
            double blockChance = Math.random();
            int damage = monster.attack();
            if (!(blockChance < defenseFromPlayer)){
                System.out.println(monster.getName() + " greift an und verursacht " + damage + " Schaden!");
                defender.getAttacked(damage);
            } else {
                System.out.println("Du hast den Angriff geblockt!");
            }

        }

        return null;
    }

    private static boolean areMonstersAlive(List<Monster> monsters) {
        for (Monster monster : monsters) {
            if (monster.getCurrentHP() > 0) {
                return true;
            }
        }
        return false;
    }

}
