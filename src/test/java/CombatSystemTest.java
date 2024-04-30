import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class CombatSystemTest {

    @Test
    void playerAttackMonster() {
        PlayerMock playerMock = new PlayerMock("Testplayer", CharacterClasses.WAFFENMEISTER);
        String inputs = "1" + "\n";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(inputs.getBytes());
        System.setIn(byteArrayInputStream);
        MonsterMock monstermock = new MonsterMock();
        CombatSystem combatSystem = new CombatSystem(playerMock);
        combatSystem.setDungeon(new Dungeon());
        combatSystem.setMonster(monstermock);
        combatSystem.playerAttackMonster();
        Assertions.assertEquals(20, monstermock.damageTaken);

    }

    @Test
    void monsterAttackPlayer() {
        PlayerMock player = new PlayerMock("Testplayer", CharacterClasses.WAFFENMEISTER);
        MonsterMock monster = new MonsterMock();
        CombatSystem combatSystem = new CombatSystem(player);
        combatSystem.setMonster(monster);
        combatSystem.monsterAttackPlayer();
        Assertions.assertEquals(25, player.damageTaken);

    }
}