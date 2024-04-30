import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

public class WeaponVendorTest {
    @Test
    void weaponVendorTestWaffenmeister(){
        WeaponVendor weaponVendor = new WeaponVendor();
        String inputs = "1" + "\n" + "1" + "\n" + "1" + "\n";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(inputs.getBytes());
        System.setIn(byteArrayInputStream);
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
        PlayerMock playerMock = new PlayerMock("test", CharacterClasses.MAGIER);
        WeaponEquipment.getInstance().setStarterWeapons(playerMock);
        weaponVendor.visit(playerMock);
        Assertions.assertEquals(30, playerMock.getCharacterInventory().getCurrencyAmount());



    }
}
