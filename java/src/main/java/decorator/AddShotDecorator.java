package decorator;

/**
 * This class implements a CoffeeDecorator concretion for decorating an additional
 * shot of espresso. It modifies the returned cost value appropriately.
 */
public class AddShotDecorator extends CoffeeDecoratorAbstract {

    /**
     * Paramaterized constructor that decorates a coffee component
     * @param component Coffee component to decorate
     */
    public AddShotDecorator(Coffee component) {
        super(component);
    }

    /***
     * Method implementation for decorated getCost() behavior
     * @return double value of cost
     */
    public double getCost() {
        return this.component.getCost() + 0.9; // increase cost by 90 cents
    }
}
