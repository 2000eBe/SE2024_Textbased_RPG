import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AbilityTest {
    @Test
    void executeAbilityWaffenmeister1(){
        PlayerCharacter player = new PlayerMock("test", CharacterClasses.WAFFENMEISTER);
        MonsterMock monster = new MonsterMock();
        Ability.executeAbility("Zerschmetternder Hieb", player, monster);
        Assertions.assertEquals(20, monster.damageTaken);
    }

    @Test
    void executeAbilityWaffenmeister2(){
        PlayerMock player = new PlayerMock("test", CharacterClasses.WAFFENMEISTER);
        MonsterMock monster = new MonsterMock();
        Ability.executeAbility("Schildaura", player, monster);
        Assertions.assertEquals(2.0, player.curseTaken);
    }

    @Test
    void executeAbilityWaffenmeister3(){
        PlayerCharacter player = new PlayerMock("test", CharacterClasses.WAFFENMEISTER);
        MonsterMock monster = new MonsterMock();
        Ability.executeAbility("Wirbelschlag", player, monster);
        Assertions.assertEquals(20, monster.damageTaken);
    }

    @Test
    void executeAbilityWaffenmeister4(){
        PlayerCharacter player = new PlayerMock("test", CharacterClasses.WAFFENMEISTER);
        MonsterMock monster = new MonsterMock();
        Ability.executeAbility("Hinrichten", player, monster);
        Assertions.assertEquals(44, monster.damageTaken);
    }

    @Test
    void executeAbilityWaffenmeister5(){
        PlayerCharacter player = new PlayerMock("test", CharacterClasses.WAFFENMEISTER);
        MonsterMock monster = new MonsterMock();
        Ability.executeAbility("Schlachtruf", player, monster);
        Assertions.assertEquals(0.75, monster.curseTaken);
    }

    // Magier
    @Test
    void executeAbilityMagier1(){
        PlayerCharacter player = new PlayerMock("test", CharacterClasses.MAGIER);
        MonsterMock monster = new MonsterMock();
        Ability.executeAbility("Feuerball", player, monster);
        Assertions.assertEquals(20, monster.damageTaken);
    }

    @Test
    void executeAbilityMagier2(){
        PlayerMock player = new PlayerMock("test", CharacterClasses.MAGIER);
        MonsterMock monster = new MonsterMock();
        Ability.executeAbility("Heilaura", player, monster);
        Assertions.assertEquals(40, player.healTaken);
    }

    @Test
    void executeAbilityMagier4(){
        PlayerCharacter player = new PlayerMock("test", CharacterClasses.MAGIER);
        MonsterMock monster = new MonsterMock();
        Ability.executeAbility("Feuerschwall", player, monster);
        Assertions.assertEquals(26, monster.damageTaken);
    }

    @Test
    void executeAbilityMagier5(){
        PlayerCharacter player = new PlayerMock("test", CharacterClasses.MAGIER);
        MonsterMock monster = new MonsterMock();
        Ability.executeAbility("Meteor", player, monster);
        Assertions.assertEquals(50, monster.damageTaken);
    }

    @Test
    void executeAbilityMagier3(){
        PlayerCharacter player = new PlayerMock("test", CharacterClasses.MAGIER);
        MonsterMock monster = new MonsterMock();
        Ability.executeAbility("Schwächender Fluch", player, monster);
        Assertions.assertEquals(0.5, monster.curseTaken);
    }
}
