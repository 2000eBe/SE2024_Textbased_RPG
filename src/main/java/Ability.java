// This class represents all the abilities that can be unlocked or learned by the player
public class Ability {
    private String name;
    private String description;
    private int levelRequirement;

    public Ability(String name, String description, int levelRequirement) {
        this.name = name;
        this.description = description;
        this.levelRequirement = levelRequirement;
    }

    public static void executeAbility(String abilityName, CombatInterface playerAttacker, CombatInterface defender) {
        WeaponAttributes attackerAttributes = playerAttacker.getEquippedWeapon().getAttributes();
        int baseDamage = attackerAttributes.getBaseAttackPoints();
        int baseCritPoints = attackerAttributes.getBaseCritPoints();
        double critChance = attackerAttributes.getCritChance();
        int damage = 0;
        switch (abilityName) {
            case "Feuerball":
                int mpCost1 = 20;
                if (playerAttacker.getCurrentMP() < mpCost1){
                    System.out.println("Du kannst die Fähigkeit nicht ausführen! Zu wenig MP!");
                } else {
                    playerAttacker.subtractMP(mpCost1);
                    damage = calculateDamageWithCrit(baseDamage, baseCritPoints, critChance, 1);
                    if(!checkIfBlocked(abilityName, defender)){
                        defender.getAttacked(damage,true);
                        attackMessage(abilityName, damage);
                    } else {
                        blockMessage(abilityName);
                    }
                }
                break;
            case "Heilaura":
                int mpCost2 = 30;
                if (playerAttacker.getCurrentMP() < mpCost2){
                    System.out.println("Du kannst die Fähigkeit nicht ausführen! Zu wenig MP!");
                } else {
                    playerAttacker.subtractMP(mpCost2);
                    System.out.println("Du heilst dich um 40 HP!");
                    playerAttacker.heal(40);
                }
                break;
            case "Schwächender Fluch":
                int mpCost3 = 15;
                if (playerAttacker.getCurrentMP() <mpCost3){
                    System.out.println("Du kannst die Fähigkeit nicht ausführen! Zu wenig MP!");
                } else {
                    playerAttacker.subtractMP(mpCost3);
                    if (!checkIfBlocked(abilityName, defender)){
                        System.out.println("Du reduzierst die Verteidigung deines Gegners mit dem Fluch um die Hälfte. Er blockt nun seltener!");
                        defender.curseDefense(0.5); // half defense of monster
                    } else {
                        blockMessage(abilityName);
                    }
                }
                break;
            case "Feuerschwall":
                int mpCost4 = 30;
                if (playerAttacker.getCurrentMP() < mpCost4){
                    System.out.println("Du kannst die Fähigkeit nicht ausführen! Zu wenig MP!");
                } else {
                    playerAttacker.subtractMP(mpCost4);
                    damage = calculateDamageWithCrit(baseDamage, baseCritPoints, critChance*1.3, 1.3);
                    if(!checkIfBlocked(abilityName, defender)){
                        defender.getAttacked(damage,true);
                        attackMessage(abilityName, damage);
                    } else {
                        blockMessage(abilityName);
                    }
                }
                break;
            case "Meteor":
                int mpCost5 = 40;
                if (playerAttacker.getCurrentMP() < mpCost5){
                    System.out.println("Du kannst die Fähigkeit nicht ausführen! Zu wenig MP!");
                } else {
                    playerAttacker.subtractMP(mpCost5);
                    damage = calculateDamageWithCrit(baseDamage, baseCritPoints, critChance, 2.5);
                    if(!checkIfBlocked(abilityName, defender)){
                        attackMessage(abilityName, damage);
                        defender.getAttacked(damage,true);
                    } else {
                        blockMessage(abilityName);
                    }
                }
                break;
            case "Zerschmetternder Hieb":
                damage = calculateDamageWithCrit(baseDamage, baseCritPoints, critChance, 1);
                if(!checkIfBlocked(abilityName, defender)){
                    attackMessage(abilityName, damage);
                    defender.getAttacked(damage,true);
                } else {
                    blockMessage(abilityName);
                }
                break;
            case "Schildaura":
                boolean activeAura = false;
                if(!activeAura){
                    playerAttacker.curseDefense(2); // as amount is >1 it will increase / double defense
                    activeAura = true;
                } else
                    System.out.println("Deine Schildaura hat kein Effekt, da du bereits eine Aura trägst.");
                break;
            case "Wirbelschlag":
                damage = calculateDamageWithCrit(baseDamage, baseCritPoints, critChance*1.5, 1);
                if(!checkIfBlocked(abilityName, defender)){
                    attackMessage(abilityName, damage);
                    defender.getAttacked(damage,true);
                } else {
                    blockMessage(abilityName);
                }
                break;
            case "Hinrichten":
                damage = calculateExecutionDamage(baseDamage, baseCritPoints, critChance, 2.2, defender);
                if(!checkIfBlocked(abilityName, defender)){
                    attackMessage(abilityName, damage);
                    defender.getAttacked(damage, true);
                } else {
                    blockMessage(abilityName);
                }
                break;
            case "Schlachtruf":
                if (!checkIfBlocked(abilityName, defender)){
                    System.out.println("Du schüchterst dein Gegener ein. Er verlieren ein Viertel seiner Verteidigung. Er blockt nun seltener!");
                    defender.curseDefense(0.75); // half defense of monster
                } else {
                    blockMessage(abilityName);
                }
                break;
            default:
                System.out.println("Ungültiger Fertigkeitsname");
        }


    }

    private static void blockMessage(String abilityName) {
        String blockString = ("Monster hat " + abilityName + " geblockt!");
        System.out.println(blockString);
    }

    private static void attackMessage(String abilityName, int damage) {
        String attackString = ("Du hast mit " + abilityName + " " + damage + " Schaden zugefügt!");
        System.out.println(attackString);
    }

    private static int calculateExecutionDamage(int baseDamage, int baseCritPoints, double critChance, double skillBias, CombatInterface enemy) {
        if((double) enemy.getCurrentHP() / enemy.getMaxHP() <= 0.3){
            return (int) enemy.getCurrentHP();
        } else {
            double random = Math.random();
            if (random < critChance) {
                return (int) ((baseDamage + baseCritPoints) * skillBias); // Increased damage when critical hit
            } else {
                return (int) (baseDamage*skillBias); // normale base damage of chosen weapon
            }
        }
    }

    private static boolean checkIfBlocked(String ability, CombatInterface defender) {
        double blockChance = ((double) defender.getDefense() / 100);
        double random = Math.random();
        if (random < blockChance){
            return true;
        } else {
            return false;
        }

    }

    // the calculation of the damage dealt is always the same but the skillBias is different for each ability!
    private static int calculateDamageWithCrit(int baseDamage,int baseCritPoints, double critChance, double skillBias) {
        double random = Math.random();
        if (random < critChance) {
            return (int) ((baseDamage + baseCritPoints) * skillBias); // Increased damage when critical hit
        } else {
            return (int) (baseDamage*skillBias); // normale base damage of chosen weapon
        }
    }

    // Getter for ability name
    public String getName() {
        return name;
    }

    // Getter for ability description
    public String getDescription() {
        return description;
    }

    // Getter for needed level for ability
    public int getLevelRequirement() {
        return levelRequirement;
    }
}

