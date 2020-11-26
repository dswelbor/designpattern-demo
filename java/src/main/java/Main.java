import nullObject.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    // List of valid args
    private static List<String> allArgs = Arrays.asList("-nullObject");


    private static void runNullObject(){

        ConcreteHouse defaultHouse = new ConcreteHouse(new DefaultOrder(), new DefaultFormatter());
        ConcreteHouse randomHouse = new ConcreteHouse(new RandomOrder(), new DefaultFormatter());
        ConcreteHouse echoHouse = new ConcreteHouse(new DefaultOrder(), new EchoFormatter());
        ConcreteHouse randomEchoHouse = new ConcreteHouse(new RandomOrder(), new EchoFormatter());

        System.out.println("Regular House:");
        System.out.println(defaultHouse.recite());

        System.out.println("\n\nRandom Ordered House");
        System.out.println(randomHouse.recite());

        System.out.println("\n\nEcho formatted house");
        System.out.println(echoHouse.recite());

        System.out.println("\n\nRandom ordered, Echo Formatted House");
        System.out.println(randomEchoHouse.recite());


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
        if (cliArgs.contains("-nullObject")){
            runNullObject();
        }

    }

} 