import java.util.Random;

// This Class is a randomgenerator for different events and occasions
public class RandomGenerator {
    private Random random;

    public RandomGenerator(){
        this.random = new Random();
    }

    // Roll a number between 1 and 20 like in a dnd game
    public int rollDnd20(){
        return random.nextInt(20) + 1;
    }

    /* How to implement the dnd roll in a fight
    *  import RandomGenerator randomGenerator = new RandomGenerator();
    *  int dndRoll = randomGenerator.rollDnd20();
    *  System.out.println("Wurf war eine : " + dndRoll);
    * */

}
