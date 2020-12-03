package decorator;

/**
 * This class implements a CoffeeDecorator concretion for decorating coffee as
 * a top shelf coffee. Top shelf coffees are double in price. It modifies the
 * returned cost value appropriately.
 */
public class TopShelfDecorator extends CoffeeDecoratorAbstract {

    /**
     * Parametrized ctor decorates/wraps a Coffee component.
     * @param component Coffee component to decorate
     */
    public TopShelfDecorator(Coffee component) {
        super(component);
    }

    /**
     * Method adjusts the returned cost value for Coffee object as being top
     * shelf. It effectively doubles the cost of that coffee.
     * @return double value of cost
     */
    @Override
    public double getCost() {
        return this.component.getCost() * 2;
    }
}
