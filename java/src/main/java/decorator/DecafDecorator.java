package decorator;

/**
 * This class implements a CoffeeDecorator concretion for decorating coffee as
 * decaf. It modifies the returned cost value appropriately.
 */
public class DecafDecorator extends CoffeeDecoratorAbstract {

    /**
     * Parameterized ctor wraps a coffee object, decorating it.
     * @param component Coffee component to decorate
     */
    public DecafDecorator(Coffee component) {
        super(component);
    }

    /**
     * Method adjusts the returned cost value for Coffee object.
     * @return double value of cost
     */
    @Override
    public double getCost() {
        return this.component.getCost() + 0.1; // add 10 cents
    }
}
