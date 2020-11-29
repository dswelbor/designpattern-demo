import adapter.Headphones;
import adapter.USBAdapter;
import decorator.AddShotDecorator;
import decorator.Coffee;
import decorator.CoffeeBase;
import decorator.DecafDecorator;
import decorator.TopShelfDecorator;
//import factory.Horse;
//import factory.Snake;
import factory.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class Main {
    // List of valid args
    private static List<String> allArgs = Arrays.asList(
            "-decorator",
            "-factory",
            "-adapter");

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

    public static void runFactory() {
        // TODO: Implement me
        System.out.println("--- Start Factory Example ---");

        AnimalFactory racingFactory = new RaceHorseFactory();
        doFactoryMethod(racingFactory, 3);
        //System.out.print("\n");

        AnimalFactory snakeFactory = new SnakeCloningFactory();
        doFactoryMethod(snakeFactory, 3);
        //System.out.print("\n");

        AnimalFactory petFactory = new AquaticPetFactory();
        doFactoryMethod(petFactory, 3);

        System.out.println("--- End Factory Example ---\n");
    }

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