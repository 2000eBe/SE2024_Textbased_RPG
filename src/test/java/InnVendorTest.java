import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

public class InnVendorTest {

    @Test
    void innVendorTest(){
        InnVendor innVendor = new InnVendor();
        String inputs = "1" + "\n";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(inputs.getBytes());
        System.setIn(byteArrayInputStream);
        PlayerMock playerMock = new PlayerMock("test", CharacterClasses.MAGIER);
        innVendor.visit(playerMock);
        Assertions.assertTrue(playerMock.visitedInn);

    }
}
