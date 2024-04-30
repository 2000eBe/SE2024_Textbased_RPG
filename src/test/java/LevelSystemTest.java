import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class LevelSystemTest {

    @Test
    void checkExpGained(){
        PlayerCharacter playerCharacter = new PlayerCharacter("testplayer", CharacterClasses.MAGIER);
        playerCharacter.grantExp(500);
        int currentLevel = playerCharacter.getCurrentLevel();
        Assertions.assertEquals(3, currentLevel);
    }
}