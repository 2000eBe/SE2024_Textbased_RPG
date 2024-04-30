import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Isolated;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

@Isolated
public class AlchemyVendorTest {
    @Test
    void alchemyVendorTest(){
        AlchemyVendor alchemyVendor = new AlchemyVendor();
        String inputs = "1" + "\n" + "1" + "\n" + "2" + "\n";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(inputs.getBytes());
        System.setIn(byteArrayInputStream);
        Main.userinput = new Scanner(System.in);
        PlayerMock playerMock = new PlayerMock("test", CharacterClasses.MAGIER);
        alchemyVendor.visit(playerMock);
        Assertions.assertEquals(3, playerMock.getCharacterInventory().getNumAvailableInventorySpace());


    }

    @Test
    void alchemyVendorTest1(){
        AlchemyVendor alchemyVendor = new AlchemyVendor();
        String inputs = "1" + "\n" + "2" + "\n" + "2" + "\n";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(inputs.getBytes());
        System.setIn(byteArrayInputStream);
        Main.userinput = new Scanner(System.in);
        PlayerMock playerMock = new PlayerMock("test", CharacterClasses.MAGIER);
        alchemyVendor.visit(playerMock);
        Assertions.assertEquals(3, playerMock.getCharacterInventory().getNumAvailableInventorySpace());


    }
}
