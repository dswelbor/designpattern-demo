import decorator.AddShotDecorator;
import decorator.Coffee;
import decorator.CoffeeBase;
import decorator.DecafDecorator;
import decorator.TopShelfDecorator;

public class Main {

    public static void runDecorator() {
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
    }

    public static void main(String[] pArgs) {
        runDecorator();
    }

}
