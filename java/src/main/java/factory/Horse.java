package factory;

/**
 * Horse class is a concrete implementation of the Animal interface. Horses
 * age as they ride and have a prime when they are the fastest. Particularly
 * young or old horses ride slower. Horses can be ridden to death.
 */
public class Horse implements Animal{
    public static final int LIFE_EXPECTANCY = 30;
    public static final int LIFE_EXPECTANCY_VARIANCE = 10;
    public static final int RIDE_COUNTER_THRESHOLD = 5;
    public static final int PRIME_LOWER = 7;
    public static final int PRIME_UPPER = 14;

    private int rideSpeed;
    private String name;
    private String description;
    private int age;
    private int deathAge;
    private int rideCounter;


    /**
     * Parameterized ctor to instantiate a horse
     * @param name String name of horse
     * @param description String description of horse
     * @param speed int ride speed
     */
    public Horse(String name, String description, int speed) {
        this.name = name;
        this.description = description;
        this.rideSpeed = speed;

        // calculate random death age
        int deathAgeVariance = RandomResult.getInt(LIFE_EXPECTANCY_VARIANCE);
        int deathOffset = deathAgeVariance - LIFE_EXPECTANCY_VARIANCE / 2;
        this.deathAge = LIFE_EXPECTANCY + deathOffset;
        // calculate random age
        this.age = RandomResult.getInt(deathAge);

        // Set initial number of rides
        this.rideCounter = 0;
    }

    @Override
    public int move() {
        return 0;
    }

    @Override
    public String view() {
        return null;
    }
}
