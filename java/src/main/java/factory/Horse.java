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

    /**
     * Method implements Animal move behavior for horse. Horses run faster in
     * their prime, so a horse aged between 7 and 14 (inclusive) will run
     * 50% faster. Horses age as they run as well.
     * @return distance moved
     */
    @Override
    public int move() {
        // base case - horse died of old age
        if (this.age > this.deathAge) {
            return 0;
        }
        // age horse
        if (++this.rideCounter > RIDE_COUNTER_THRESHOLD) {
            ++this.age;
            this.rideCounter = 0;
        }
        // ride horse
        int moveDistance = this.rideSpeed;
        // prime - inclusive bounds
        if (this.age >= PRIME_LOWER && this.age <= PRIME_UPPER) {
            // boost speed by 50% offset
            int offset = Long.valueOf(Math.round(this.rideSpeed / 2.0)).intValue();
            moveDistance = this.rideSpeed + offset;
        }

        return moveDistance;
    }

    @Override
    public String view() {
        String horseDescription = winnyIze();
        StringBuilder summary = new StringBuilder();
        summary.append(this.name).append(" is a horse.\n").append(horseDescription);
        String result = summary.toString();
        return result;
    }

    private String winnyIze() {
        StringBuilder winny = new StringBuilder(this.description);
        // special case - dead
        if (this.age > this.deathAge) {
            winny.insert(0,"[...Only this and nothing more...]\n");
            winny.append("\n[..Shall be lifted—-nevermore!]\n\t - R.I.P. ");
            winny.append(this.name).append(" (");
            winny.append(this.age).append(" years)");
        }
        // alive
        else {
            winny.append("Nei-eigh-eigh...");
        }

        return winny.toString();
    }
}
