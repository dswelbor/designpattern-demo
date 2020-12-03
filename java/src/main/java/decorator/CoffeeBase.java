package decorator;

/**
 * Class provides basic Coffee implementation.
 */
public class CoffeeBase extends Coffee {
    // Declare default cost
    public static final double DEFAULT_COST = 1.0;

    /**
     * Method returns cost of a basic Coffee object
     * @return double value of cost
     */
    @Override
    public double getCost() {
        return DEFAULT_COST;
    }
}
