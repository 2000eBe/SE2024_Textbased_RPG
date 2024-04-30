import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Isolated;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

@Isolated
public class WeaponVendorTest {
    @Test
    void weaponVendorTestWaffenmeister(){
        WeaponVendor weaponVendor = new WeaponVendor();
        String inputs = "1" + "\n" + "1" + "\n" + "1" + "\n";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(inputs.getBytes());
        System.setIn(byteArrayInputStream);
        Main.userinput = new Scanner(System.in);
        PlayerMock playerMock = new PlayerMock("test", CharacterClasses.WAFFENMEISTER);
        WeaponEquipment.getInstance().setStarterWeapons(playerMock);
        weaponVendor.visit(playerMock);
        Assertions.assertEquals(30, playerMock.getCharacterInventory().getCurrencyAmount());


    }

    @Test
    void weaponVendorTestMagier(){
        WeaponVendor weaponVendor = new WeaponVendor();
        String inputs = "1" + "\n" + "1" + "\n" + "1" + "\n";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(inputs.getBytes());
        System.setIn(byteArrayInputStream);
        Main.userinput = new Scanner(System.in);
        PlayerMock playerMock = new PlayerMock("test", CharacterClasses.MAGIER);
        WeaponEquipment.getInstance().setStarterWeapons(playerMock);
        weaponVendor.visit(playerMock);
        Assertions.assertEquals(30, playerMock.getCharacterInventory().getCurrencyAmount());



    }
}
