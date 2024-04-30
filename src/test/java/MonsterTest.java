import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MonsterTest {
    @Test
    void monsterGetsAttacked(){
        Monster monster = new Monster("testMonster", "monster", 30, 30, 15,15,15,2);
        monster.getAttacked(15, true);
        Assertions.assertEquals(15, monster.getCurrentHP());
    }
}
