import decorator.AddShotDecorator;
import decorator.Coffee;
import decorator.CoffeeBase;
import decorator.DecafDecorator;
import decorator.TopShelfDecorator;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    // List of valid args
    private static List<String> allArgs = Arrays.asList("-decorator", "-factory");

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
        System.out.println("Factory Pattern example under construction...");
        System.out.println("--- End Factory Example ---\n");
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
        if (cliArgs.contains("-decorator")) {
            runDecorator();
        }
        if (cliArgs.contains("-factory")) {
            runFactory();
        }

    }

}
