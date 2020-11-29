package factory;

import java.lang.reflect.Constructor;
import java.util.*;

/**
 * Concrete implementation of a DuckFactory
 */
public class RaceHorseFactory implements AnimalFactory {
    static String[] DEFAULT_NAMES = {"Black Beauty", "Lexington", "Winchester"};
    static String[] DEFAULT_DESCRIPTIONS = {
            "It is in full regalia - bridle, saddle, and martingale",
            "This horse is riding Kidron triumphantly through the Victory Arch in New York City",
            "He is brown, without white markings, stands 14.2 hands high and weighed 960 pounds",
    };
    public static int DEFAULT_SPEED_MIN = 25;
    public static int DEFAULT_SPEED_MAX = 50;

    // Descriptions
    private List<String> horseNames;
    private List<String> horseDescriptions;

    // Horse speed params
    private int minSpeed;
    private int maxSpeed;

    // Iterators
    private Iterator<String> nextName;
    private Iterator<String> nextDescription;




    static int DEFAULT_TIME = 5;
    int prepareTime;

    /**
     * Default ctor for a competitive race horse factory.
     * @throws IllegalArgumentException if maxSpeed < minSpeed
     */
    public RaceHorseFactory() {
        // set horse speed params
        this.minSpeed = DEFAULT_SPEED_MIN;
        this.maxSpeed = DEFAULT_SPEED_MAX;
        // max must be >= min
        if (maxSpeed < minSpeed) {
            throw new IllegalArgumentException("RaceHorse max speed must be >= min");
        }

        this.horseNames = Arrays.asList(DEFAULT_NAMES);
        this.horseDescriptions = Arrays.asList(DEFAULT_DESCRIPTIONS);

        // shuffle names and descriptions
        Collections.shuffle(horseNames);
        Collections.shuffle(horseDescriptions);
        this.nextName = horseNames.listIterator();
        this.nextDescription = horseDescriptions.listIterator();
    }

    /**
     * Parameterized ctor for instantiating a RaceHorseFactory using a json
     * config for factory parameters. This ctor is currently not implemented.
     * @param configFilename filename for config file
     * @throws UnsupportedOperationException currently not implemented
     */
    public RaceHorseFactory(String configFilename) {
        // TODO: Implement me with importing config from a json file store
        throw new UnsupportedOperationException("Constructor not implemented");
    }

    /**
     * Creates a race horse based on configured min/max speeds and pool of names
     * and descriptions.
     * @return race Horse
     */
    public Animal create() {
        // calculate speed
        int range = this.maxSpeed - this.minSpeed;
        int offset = RandomResult.getInt(range + 1);
        int horseSpeed = this.minSpeed + offset;

        return new Horse(getNextName(), getNextDescription(), horseSpeed);
    }


    /**
     * Helper method returns the next horse name. Horse names are in a random
     * circular list structure.
     * @return next horse name
     */
    public String getNextName() {
        try {
            return this.nextName.next();
        }
        // Make names random circular list
        catch (NoSuchElementException e) {
            Collections.shuffle(horseNames);
            this.nextName = this.horseNames.iterator();
            return this.nextName.next();
        }
    }

    /**
     * Helper method returns the next horse description. Horse descriptions are
     * in a random circular list structure.
     * @return next horse description
     */
    public String getNextDescription() {
        try {
            return this.nextDescription.next();
        }
        // Make names random circular list
        catch (NoSuchElementException e) {
            Collections.shuffle(horseDescriptions);
            this.nextDescription = this.horseDescriptions.iterator();
            return this.nextDescription.next();
        }
    }
}
