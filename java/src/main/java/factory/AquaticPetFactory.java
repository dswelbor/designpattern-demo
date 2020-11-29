package factory;

import java.util.*;

/**
 * Concrete implementation of a DuckFactory
 */
public class AquaticPetFactory implements AnimalFactory {
    static String[] DEFAULT_DUCK_NAMES = {"Donald", "Huey", "Dewey"};
    static String[] DEFAULT_DUCK_DESCRIPTIONS = {
            "He has ruffled yellow feathers and is a trouble maker at hard. Diction " +
                    "might not be his strong suit, but he has a heart of gold",
            "This duck will be young at heart forever and puts family first",
            "A best-in-class duck who often trips over the finish line. As " +
                    "bad as things might get, he can always make you smile"
    };
    static String[] DEFAULT_SNAKE_NAMES = {"Kaa", "Asmodeus", "Nagaina"};
    static String[] DEFAULT_SNAKE_DESCRIPTIONS = {
            "This snake is a queen. She is is the most beautiful cobra you " +
                    "have ever seen and is beloved to Rudyard Kipling",
            "A trickster, this snake hides in the shadows and is seldom resting",
            "This snake is quite pythonic, unconditional, and always handles " +
                    "exceptions when it tries"
    };
    public static int DEFAULT_SPEED_MIN = 12;
    public static int DEFAULT_SPEED_MAX = 20;

    // Descriptions
    private List<String> duckNames;
    private List<String> duckDescriptions;
    private List<String> snakeNames;
    private List<String> snakeDescriptions;

    // Horse speed params
    private int minSpeed;
    private int maxSpeed;

    // Iterators
    private Iterator<String> nextDuckName;
    private Iterator<String> nextDuckDescription;
    private Iterator<String> nextSnakeName;
    private Iterator<String> nextSnakeDescription;



    /**
     * Default ctor for a competitive race horse factory.
     * @throws IllegalArgumentException if maxSpeed < minSpeed
     */
    public AquaticPetFactory() {
        // set horse speed params
        this.minSpeed = DEFAULT_SPEED_MIN;
        this.maxSpeed = DEFAULT_SPEED_MAX;
        // max must be >= min
        if (maxSpeed < minSpeed) {
            throw new IllegalArgumentException("AquaticPet max speed must be >= min");
        }

        this.duckNames = Arrays.asList(DEFAULT_DUCK_NAMES);
        this.duckDescriptions = Arrays.asList(DEFAULT_DUCK_DESCRIPTIONS);
        this.snakeNames = Arrays.asList(DEFAULT_SNAKE_NAMES);
        this.snakeDescriptions = Arrays.asList(DEFAULT_SNAKE_DESCRIPTIONS);

        // shuffle names and descriptions
        Collections.shuffle(duckNames);
        Collections.shuffle(duckDescriptions);
        Collections.shuffle(snakeNames);
        Collections.shuffle(snakeDescriptions);
        this.nextDuckName = duckNames.listIterator();
        this.nextDuckDescription = duckDescriptions.listIterator();
        this.nextSnakeName = snakeNames.listIterator();
        this.nextSnakeDescription = snakeDescriptions.listIterator();
    }

    /**
     * Parameterized ctor for instantiating a AquaticPetFactory using a config
     * file for factory parameters. This ctor is currently not implemented.
     * @param configFilename filename for config file
     * @throws UnsupportedOperationException currently not implemented
     */
    public AquaticPetFactory(String configFilename) {
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
        int petSpeed = this.minSpeed + offset;
        PetType[] petTypes = PetType.values();
        int randTypeOrdinal = RandomResult.getInt(petTypes.length);
        PetType randType = petTypes[randTypeOrdinal];


        return getNewPet(randType, getNextName(randType),
                getNextDescription(randType), petSpeed);
    }

    /*
    Both of the following helper methods use conditionals and are prime
    candidates to replace conditionals with polymorphism a la Martin Fowler
     */

    /**
     * Helper method returns the next pet name. Pet names are in a random
     * circular list structure.
     * @param nameType type of pet
     * @return next horse name
     * @throws IllegalArgumentException if PetType isn't recognized
     */
    public String getNextName(PetType nameType) {
        Iterator<String> petNameIter;
        if (nameType == PetType.DUCK){
            petNameIter = this.nextDuckName;
        }
        else if (nameType == PetType.SNAKE) {
            petNameIter = this.nextSnakeName;
        }
        else {
            throw new IllegalArgumentException("Unrecognized PetType");
        }

        // TODO: Replace my conditionals with polymorphism
        try {
            return petNameIter.next();
        }
        // Make names random circular list
        catch (NoSuchElementException e) {
            if (nameType == PetType.DUCK){
                Collections.shuffle(duckNames);
                petNameIter = this.duckNames.iterator();
            }
            else if (nameType == PetType.SNAKE) {
                Collections.shuffle(snakeNames);
                petNameIter = this.snakeNames.iterator();
            }
            else {
                // This line should be unreachable
                throw new IllegalArgumentException("Unrecognized PetType");
            }
            return petNameIter.next();
        }
    }

    /**
     * Helper method returns the next aquatic pet descriptions. Pet descriptions
     * are in a random circular list structure.
     * @return next horse description
     */
    public String getNextDescription(PetType descriptionType) {
        // TODO: Replace my conditionals with polymorphism
        Iterator<String> petDescrIter;
        if (descriptionType == PetType.DUCK){
            petDescrIter = this.nextDuckDescription;
        }
        else if (descriptionType == PetType.SNAKE) {
            petDescrIter = this.nextSnakeDescription;
        }
        else {
            throw new IllegalArgumentException("Unrecognized PetType");
        }

        // TODO: Replace my conditionals with polymorphism
        try {
            return petDescrIter.next();
        }
        // Make names random circular list
        catch (NoSuchElementException e) {
            if (descriptionType == PetType.DUCK){
                Collections.shuffle(duckDescriptions);
                petDescrIter = this.duckDescriptions.iterator();
            }
            else if (descriptionType == PetType.SNAKE) {
                Collections.shuffle(snakeDescriptions);
                petDescrIter = this.snakeDescriptions.iterator();
            }
            else {
                // This line should be unreachable
                throw new IllegalArgumentException("Unrecognized PetType");
            }
            return petDescrIter.next();
        }
    }

    /**
     * Helper method abstracts creating a new pet. Does this based on passed type,
     * name, description, and speed
     * @param nameType type of new pet Animal
     * @param name of new pet Animal
     * @param description of new pet Animal
     * @param speed of new pet Animal
     * @return new pet Animal
     */
    public Animal getNewPet(PetType nameType, String name, String description, int speed) {
        // TODO: Replace conditionals with late binding
        if (nameType == PetType.DUCK){
            return new Duck(name, description, speed);
        }
        else if (nameType == PetType.SNAKE) {
            return new Snake(name, description, speed);
        }
        else {
            throw new IllegalArgumentException("Unrecognized PetType");
        }
    }

    /**
     * Simple enumeration for different pet types
     */
    enum PetType {
        DUCK,
        SNAKE
    }
}
