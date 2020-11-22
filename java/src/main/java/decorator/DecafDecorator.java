package decorator;

public class DecafDecorator extends CoffeeDecoratorAbstract {

    public DecafDecorator(Coffee component) {
        super(component);
    }

    @Override
    public double getCost() {
        return this.component.getCost() + 0.1; // add 10 cents
    }
}
