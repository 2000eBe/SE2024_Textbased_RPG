import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

public class TownHealerTest {

    @Test
    void testTownHealer(){
        TownhealerVendor townHealer = new TownhealerVendor();
        String inputs = "1" + "\n";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(inputs.getBytes());
        System.setIn(byteArrayInputStream);
        PlayerMock playerMock = new PlayerMock("test", CharacterClasses.WAFFENMEISTER);
        townHealer.visit(playerMock);
        Assertions.assertEquals(25, playerMock.healTaken);

    }
}
