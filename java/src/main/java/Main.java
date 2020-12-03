import adapter.Headphones;
import adapter.USBAdapter;
import decorator.AddShotDecorator;
import decorator.Coffee;
import decorator.CoffeeBase;
import decorator.DecafDecorator;
import decorator.TopShelfDecorator;
import factory.Animal;
import factory.AnimalFactory;
import factory.AquaticPetFactory;
import factory.RaceHorseFactory;
import factory.SnakeCloningFactory;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/***
 * This class serves to provide an entry point for the Design Pattern Demos,
 * add some utility by means of cli arg parsing, and abstract demos for each
 * design pattern.
 * @author David Welborn, Jacob Labrec
 * @version 11/30/2020
 */
public class Main {
    // List of valid args
    private static List<String> allArgs = Arrays.asList(
            "-decorator",
            "-factory",
            "-adapter");

    /**
     * Utility method sets up and runs a demo for the Adapter Pattern
     */
    public static void runAdapter() {
        System.out.println("--- Start Adapter Example ---");
        System.out.println("You've got an Iphone 5 and wanna listen to music with your 3.5 mm headphones. Easy");
        Headphones headphones = new Headphones();
        headphones.listen();

        System.out.println("\n\nBut now you've upgraded your phone to the Iphone 10. You wanna listen to music");
        System.out.println("Wait... The iphone 10 uses a different interface for headphone connections, it uses USB-C");
        System.out.println("We know Apple isn't exactly friendly to popping open the device and adjusting the hardware" +
                "so what should we do");

        System.out.println("Luckily, we know we can just use an adapter, to adapt to this new interface");
        headphones.iphone = new USBAdapter();
        System.out.println("\n\nAdapter applied, lets listen to music:");
        headphones.listen();
        System.out.println("--- End Adapter Example ---\n");
    }

    /**
     * Utility method encapsulates running the decorator demo.
     */
    public static void runDecorator() {
        System.out.println("--- Start Decorator Example ---");

        // Demonstrate decorator
        Coffee coffee = new CoffeeBase();
        System.out.println("Basic coffee: $"+ coffee.getCost());

        // Add 2 shots
        coffee = new AddShotDecorator(coffee);
        coffee = new AddShotDecorator(coffee);
        System.out.println("Coffee w/ 2 shots: $"+ coffee.getCost());

        // make it decaf
        coffee = new DecafDecorator(coffee);
        System.out.println("Decaf Coffee w/ 2 shots: $"+ coffee.getCost());

        // make it topshelf coffee
        coffee = new TopShelfDecorator(coffee);
        System.out.println("Topshelf Decaf Coffee w/ 2 shots: $"+ coffee.getCost());

        System.out.println("--- End Decorator Example ---\n");
    }

    /**
     * Utility method encapsulates running the factory demo.
     */
    public static void runFactory() {
        System.out.println("--- Start Factory Example ---");

        AnimalFactory racingFactory = new RaceHorseFactory();
        doFactoryMethod(racingFactory, 3);

        AnimalFactory snakeFactory = new SnakeCloningFactory();
        doFactoryMethod(snakeFactory, 3);

        AnimalFactory petFactory = new AquaticPetFactory();
        doFactoryMethod(petFactory, 3);

        System.out.println("--- End Factory Example ---\n");
    }

    /**
     * Helper method abstracts the usage of different factories in a loop
     * to showcase the Factory Method Design Pattern/
     * @param factory AnimalFactory instance to use
     * @param numAnimals int number of animals to create
     */
    private static void doFactoryMethod(AnimalFactory factory, int numAnimals) {
        //AnimalFactory snakeFactory = new SnakeCloningFactory();
        String factoryName = factory.getClass().getSimpleName();
        StringBuilder actionText = new StringBuilder()
                .append("[INFO] Creating ").append(numAnimals)
                .append(" Animal objects  using ").append(factoryName).append("...");
        System.out.println(actionText.toString());
        for (int i = 0; i < numAnimals; ++i) {
            // create new Animal using factory method
            Animal newAnimal = factory.create();
            String animalType = newAnimal.getClass().getSimpleName();
            StringBuilder snakeResult = new StringBuilder()
                    .append("[INFO] Successfully created new Animal: ")
                    .append(animalType).append("\nview(): \n")
                    .append(newAnimal.view())
                    .append("\nmove(): \n").append(newAnimal.move());
            System.out.println(snakeResult.toString());
        }
    }

    /**
     * Helper method validates passed cli args are in fact valid
     * @param pArgs cli args
     * @return true if valid, false otherwise
     */
    private static boolean validateArgs(String[] pArgs) {
        // Validate args
        StringBuilder badArgs = new StringBuilder();
        for (String arg: pArgs) {
            if (!allArgs.contains(arg)) {
                badArgs.append(" ");
                badArgs.append(arg);
            }

        }
        // invalid args
        if (badArgs.length() > 0) {
            System.out.printf("Unknown command-line option(s):%s\n", badArgs.toString());
            // TODO: Add help text that informs usage of cli args

            System.exit(0);
        }
        return true;
    }

    /**
     * This is the main entry point for the Design Pattern Demo program. It
     * is configured to accept cli args and defaults to running all if no args
     * are provided.
     * @param pArgs cli args
     */
    public static void main(String[] pArgs) {
        // TODO: Refactor as abstracted cli runtime config
        List<String> cliArgs = new LinkedList<>(Arrays.asList(pArgs));
        validateArgs(pArgs);

        // Default - no params, run all
        if (cliArgs.isEmpty()) {

            cliArgs.addAll(allArgs);
        }

        // execute examples
        if (cliArgs.contains("-adapter")){
            runAdapter();
        }
        if (cliArgs.contains("-decorator")) {
            runDecorator();
        }
        if (cliArgs.contains("-factory")) {
            runFactory();
        }
    }

}