package decorator;

public class TopShelfDecorator extends CoffeeDecoratorAbstract {

    public TopShelfDecorator(Coffee component) {
        super(component);
    }

    @Override
    public double getCost() {
        return this.component.getCost() * 2;
    }
}
