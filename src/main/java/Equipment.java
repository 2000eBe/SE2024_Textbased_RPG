// This class represents all the equipment items (gear and weapons) that can be obtained and worn by the player
public class Equipment {

    // weapon parameter
        private String weaponName;
        private String weaponDescription;
        private int attackPoints;

        private int price;



    // method block

        public void weapon(String weaponName, String weaponDescription, int attackPoints){
            this.weaponName = weaponName;
            this.weaponDescription = weaponDescription;
            this.attackPoints = attackPoints;
        }



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

}
