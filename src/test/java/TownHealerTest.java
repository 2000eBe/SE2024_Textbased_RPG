import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Isolated;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

@Isolated

public class TownHealerTest {
    @Test
    void testTownHealer() throws InterruptedException {

        InputStream in = System.in;
        String inputs = "1" + "\n" + "2" + "\n";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(inputs.getBytes());
        System.setIn(byteArrayInputStream);
        Main.userinput = new Scanner(System.in);
        TownhealerVendor townHealer = new TownhealerVendor();
        InputStream in1 = System.in;
        PlayerMock playerMock = new PlayerMock("test", CharacterClasses.WAFFENMEISTER);
        townHealer.visit(playerMock);
        Assertions.assertEquals(25, playerMock.healTaken);
        System.setIn(in);
    }

}
