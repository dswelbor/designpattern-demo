import adapter.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    // List of valid args
    private static List<String> allArgs = Arrays.asList("-adapter");


    private static void runAdapter() {
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

    }

}