public class MonsterMock extends Monster {

    int damageTaken;
    double curseTaken;
    public MonsterMock() {
        super("testmonster", "testdescripiton", 25,20,5,10, 10,1);
    }

    @Override
    public int attack() {
        return 25;
    }

    @Override
    public int getDefense() {
        return 0;
    }

    @Override
    public int getAttacked(int amount, boolean defeated) {
        damageTaken = amount;
        return 20;
    }

    @Override
    public double curseDefense(double amount) {
        curseTaken = amount;
        return 5;
    }
}
