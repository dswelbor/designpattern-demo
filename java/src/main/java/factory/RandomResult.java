package factory;

import java.util.Random;

/**
 * Simple utility class to get random results
 */
public class RandomResult {
    private static Random rng = new Random();

    /**
     * Utility method to return true/false randomly
     * @return true or false
     */
    public static boolean getBoolean() {
        return rng.nextBoolean();
    }

    /**
     * Utility method to return a random number between 0 and an exclusive
     * upper bound.
     * @param upperLimit exclusive upper bound
     * @return random whole number (including 0)
     */
    public static int getInt(int upperLimit) {
        return rng.nextInt(upperLimit);
    }
}
