package factory;

import java.util.*;

/**
 * Concrete implementation of an AnimalFactory that produces cloned Snake objects.
 * The snake names are appended with unique identifiers that distinguish one
 * clone from another.
 */
public class SnakeCloningFactory implements AnimalFactory {
    static String DEFAULT_NAME = "Nagini";
    static String DEFAULT_DESCRIPTION = "This Indonesian shape-shifter has " +
            "permanently transformed into a snake and bears a soul fragment of " +
            "the dark wizard Voldemort";
    public static int DEFAULT_SPEED = 17;

    // Descriptions
    private String snakeName;
    private String snakeDescription;

    // Horse speed params
    private int snakeSpeed;

    // Track snakes
    int cloneCounter = 0;

    /**
     * Default ctor for a snake cloning factory.
     * @throws IllegalArgumentException if speed non-positive
     */
    public SnakeCloningFactory() {
        // set snake speed params
        this.snakeSpeed = DEFAULT_SPEED;

        // speed must be positive
        if (snakeSpeed <= 0) {
            throw new IllegalArgumentException("Snake must have positive movement speed");
        }

        // configure snake attributes
        this.snakeName = DEFAULT_NAME;
        this.snakeDescription = DEFAULT_DESCRIPTION;

    }

    /**
     * Parameterized ctor for instantiating a SnakeCloningFactory using a json
     * config for factory parameters. This ctor is currently not implemented.
     * @param configFilename filename for config file
     * @throws UnsupportedOperationException currently not implemented
     */
    public SnakeCloningFactory(String configFilename) {
        // TODO: Implement me with importing config from a json file store
        throw new UnsupportedOperationException("Constructor not implemented");
    }

    /**
     * Creates a cloned snake based on configured min/max speeds and pool of names
     * and descriptions.
     * @return cloned Snake
     */
    public Animal create() {
        // calculate speed
        String name = String.format("%s BB%03d", this.snakeName, ++this.cloneCounter);
        return new Snake(name, this.snakeDescription, this.snakeSpeed);
    }
}
