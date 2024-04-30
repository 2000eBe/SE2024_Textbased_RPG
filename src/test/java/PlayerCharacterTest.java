import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerCharacterTest {

    @ParameterizedTest
    @ValueSource(ints = {10, 100})
    void heal(int hp) {
        PlayerCharacter player = new PlayerCharacter("Testname", CharacterClasses.WAFFENMEISTER);
        player.getAttacked(50, true);
        Assertions.assertEquals(50,player.getCurrentHP());
        int currentHP = player.getCurrentHP();
        player.heal(hp);
        Assertions.assertEquals(Math.min(currentHP+hp, 100), player.getCurrentHP());
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 100})
    void heal2(int hp) {
        PlayerCharacter player = new PlayerCharacter("Testname", CharacterClasses.MAGIER);
        player.getAttacked(50, true);
        Assertions.assertEquals(25,player.getCurrentHP());
        int currentHP = player.getCurrentHP();
        player.heal(hp);
        Assertions.assertEquals(Math.min(currentHP+hp, 75), player.getCurrentHP());
    }

    @Test
    void mpSubstract(){
        PlayerCharacter playerCharacter = new PlayerCharacter("Testname", CharacterClasses.MAGIER);
        playerCharacter.subtractMP(100);
        int currentMP = playerCharacter.getCurrentMP();
        Assertions.assertEquals(0, currentMP);


    }
    @Test
    void restore(){
        PlayerCharacter playerCharacter = new PlayerCharacter("Testname", CharacterClasses.MAGIER);
        playerCharacter.subtractMP(100);
        playerCharacter.getAttacked(15, true);
        playerCharacter.restoreWithInn();
        int currentMP = playerCharacter.getCurrentMP();
        int currentHP = playerCharacter.getCurrentHP();
        Assertions.assertEquals(100, currentMP);
        Assertions.assertEquals(75, currentHP);
    }
    @Test
    void restore2(){
        PlayerCharacter playerCharacter = new PlayerCharacter("Testname", CharacterClasses.WAFFENMEISTER);
        playerCharacter.getAttacked(15, true);
        playerCharacter.restoreWithInn();
        int currentHP = playerCharacter.getCurrentHP();
        Assertions.assertEquals(100, currentHP);
    }

    @Test
    void restoreMana(){
        PlayerCharacter player = new PlayerCharacter("test", CharacterClasses.MAGIER);
        player.subtractMP(25);
        player.restoreMP(25);
        int currentMP = player.getCurrentMP();
        Assertions.assertEquals(100, currentMP);
    }
}