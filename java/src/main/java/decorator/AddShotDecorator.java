package decorator;

public class AddShotDecorator extends CoffeeDecoratorAbstract {

    public AddShotDecorator(Coffee component) {
        super(component);
    }

    public double getCost() {
        return this.component.getCost() + 0.9; // increase cost by 90 cents
    }
}
