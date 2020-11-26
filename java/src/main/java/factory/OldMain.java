package factory;

/**
 * Main class for this example
 */
public class OldMain {
    /**
     * Entry point for the program
     * @param pArgs cli arguments
     */
    public static void main(String[] pArgs) {
        // Duck Factories for racing

        /*AnimalFactory quickFactory = new DuckCompetitiveFactory();
        AnimalFactory longFactory = new DuckCompetitiveFactory(10);

        // Make some ducks for a quick Race
        System.out.println("Ducks with a short training time performed:");
        for (int i = 0; i < 5; ++i) {
            Animal racingDuck = quickFactory.createAnimal();
            System.out.println("Duck " + (i + 1) + "'s speed: " );
        }

        // Make some ducks for a long Race
        System.out.println("Ducks with a longer training time performed:");
        for (int i = 0; i < 5; ++i) {
            Animal racingDuck = longFactory.createAnimal();
            System.out.println("Duck " + (i + 1) + "'s speed: " + racingDuck.move());
        }

         */
    }
}
