import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Isolated;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

@Isolated
public class InnVendorTest {

    @Test
    void innVendorTest(){
        InputStream in = System.in;
        InnVendor innVendor = new InnVendor();
        String inputs = "1" + "\n";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(inputs.getBytes());
        System.setIn(byteArrayInputStream);
        Main.userinput = new Scanner(System.in);
        PlayerMock playerMock = new PlayerMock("test", CharacterClasses.MAGIER);
        innVendor.visit(playerMock);
        Assertions.assertTrue(playerMock.visitedInn);
        System.setIn(in);
    }
}
