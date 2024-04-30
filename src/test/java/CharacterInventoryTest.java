import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterInventoryTest {

    @Test
    void addPotionItemToInventory() {
        PlayerCharacter playerCharacter = new PlayerCharacter("test", CharacterClasses.MAGIER);
        playerCharacter.getCharacterInventory().addPotionItemToInventory(new PotionItems.HealthPotion());
        int numAvailableInventorySpace = playerCharacter.getCharacterInventory().getNumAvailableInventorySpace();
        Assertions.assertEquals(3, numAvailableInventorySpace);
    }
    @Test
    void usePotionItemFromInventory() {
        PlayerCharacter playerCharacter = new PlayerCharacter("test", CharacterClasses.MAGIER);
        playerCharacter.getCharacterInventory().addPotionItemToInventory(new PotionItems.HealthPotion());
        playerCharacter.getCharacterInventory().useItemFromInventory(0);
        int numAvailableInventorySpace = playerCharacter.getCharacterInventory().getNumAvailableInventorySpace();
        Assertions.assertEquals(4, numAvailableInventorySpace);
    }
    @Test
    void checkInventorySpace() {
        PlayerCharacter playerCharacter = new PlayerCharacter("test", CharacterClasses.MAGIER);
        boolean hasSpace = playerCharacter.getCharacterInventory().checkInventorySpace();
        assertFalse(hasSpace);
    }

    @Test
    void checkAffordable() {
        PlayerCharacter playerCharacter = new PlayerCharacter("test", CharacterClasses.MAGIER);
        boolean canAfford = playerCharacter.getCharacterInventory().checkAffordable(100);
        assertFalse(canAfford);
    }

    @Test
    void payGold() {
        PlayerCharacter playerCharacter = new PlayerCharacter("test", CharacterClasses.MAGIER);
        playerCharacter.getCharacterInventory().payGold(20);
        int currentCurrency = playerCharacter.getCharacterInventory().getCurrencyAmount();
        Assertions.assertEquals(-20, currentCurrency);
    }

    @Test
    void setCurrencyAmount() {
        PlayerCharacter playerCharacter = new PlayerCharacter("test", CharacterClasses.MAGIER);
        playerCharacter.getCharacterInventory().setCurrencyAmount(150);
        int currentCurrency = playerCharacter.getCharacterInventory().getCurrencyAmount();
        Assertions.assertEquals(150, currentCurrency);

    }

    @Test
    void getNumAvailableInventorySpace() {
        PlayerCharacter playerCharacter = new PlayerCharacter("test", CharacterClasses.MAGIER);
        int numAvailableInventorySpace = playerCharacter.getCharacterInventory().getNumAvailableInventorySpace();
        Assertions.assertEquals(4, numAvailableInventorySpace);
    }
}