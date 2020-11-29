package factory;

import java.lang.reflect.Constructor;
import java.util.Random;

/**
 * Concrete implementation of a DuckFactory
 */
public class CompetitiveAnimalFactory implements AnimalFactory {
    static int DEFAULT_TIME = 5;
    int prepareTime;

    /**
     * Default ctor for a competitive duck factory.
     */
    public CompetitiveAnimalFactory() {
        this.prepareTime = DEFAULT_TIME;
    }

    /**
     * Parameterized ctor for how long ducks are given to train in this factory.
     * @param time prepare time
     */
    public CompetitiveAnimalFactory(int time) {
        this.prepareTime = time;
    }

    /**
     * Creates a decorated duck based on the prepare time.
     * @return decorated Duck
     */
    public Animal create() {
        return new Horse("bob", "nothing", 25);
    }
    /*
    public Animal createAnimal() {
        Class[] decorators = {
                DuckTrainingConcrete.class,
                DuckInjuryConcrete.class,
                DuckAffinityConcrete.class};
        //Class<Duck> params;

        Random rng = new Random();
        Animal duck = new Duck("abc", "def", 0);
        // iterate through training time
        for (int i = 0; i < this.prepareTime; ++i) {
            int roll = rng.nextInt(decorators.length);
            try {
                // Get a reference to the ctor
                Constructor<DuckDecoratorAbs> ctor = decorators[roll].getConstructor(Animal.class);
                // Create a new instance with that ctor
                duck = ctor.newInstance(duck);
            }
            catch (Exception e) {
                // Obviously this needs better exception handling
                e.printStackTrace();
            }
        }

        // Return decorated duck
        return duck;
    }*/
}
