import java.util.Random;

// This Class should represent a special Event in the game, that can be triggered
public class Event {

    public void spawnTreasureChest(PlayerCharacter pc){
        Random random = new Random();
        int roll = random.nextInt(100)+1; // roll between 1 and 100
        if (roll <= 50){
            // 50% chance to contain gold
            int goldAmount = random.nextInt(100)+1; // Gold amount between 1 and 100
            System.out.println("Du hast eine Goldtruhe mit " + goldAmount + " Gold gefunden und sammelst diese auf.");
            int currentGold = pc.getCharacterInventory().getCurrencyAmount();
            pc.getCharacterInventory().setCurrencyAmount(currentGold + goldAmount);
        } else {
            // 50% Chance to contain a potion
            PotionItems potion = PotionItems.getRandomPotion();
            System.out.println("Du hast eine Truhe mit " + potion + " gefunden und sammelst diese auf.");
            pc.getCharacterInventory().addPotionItemToInventory(potion);

        }
    }
}
