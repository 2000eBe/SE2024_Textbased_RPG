import java.util.Arrays;
import java.util.List;

// This class represents all the equipment items (gear and weapons) that can be obtained and worn by the player
public class Equipment {

    // weapon parameter
        private String weaponName;
        private String weaponDescription;
        private int attackPoints;

        // gear parameter
        private String gearName;
        private int defensivePoints;
        private String gearDescription;

    // method block



    // getter & setter block
        public String getWeaponName() {
            return weaponName;
        }

        public void setWeaponName(String weaponName) {
            this.weaponName = weaponName;
        }

        public String getWeaponDescription() {
            return weaponDescription;
        }

        public void setWeaponDescription(String weaponDescription) {
            this.weaponDescription = weaponDescription;
        }

        public int getAttackPoints() {
            return attackPoints;
        }

        public void setAttackPoints(int attackPoints) {
            this.attackPoints = attackPoints;
        }

        public String getGearName() {
            return gearName;
        }

        public void setGearName(String gearName) {
            this.gearName = gearName;
        }

        public int getDefensivePoints() {
            return defensivePoints;
        }

        public void setDefensivePoints(int defensivePoints) {
            this.defensivePoints = defensivePoints;
        }

        public String getGearDescription() {
            return gearDescription;
        }

        public void setGearDescription(String gearDescription) {
            this.gearDescription = gearDescription;
        }
}
