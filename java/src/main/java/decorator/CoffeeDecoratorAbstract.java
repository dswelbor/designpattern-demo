package decorator;

/**
 * Class provides a common interface for Coffee decorator concretions.
 * This abstracts the implementation details for the various decorators and
 * enforces the "is-a" and "has-a" nature of decorators.
 */
public abstract class CoffeeDecoratorAbstract extends Coffee {

    // All Coffee decorators "have-a" or wrap a Coffee object
    protected Coffee component;

    /**
     * Parameterized ctor wraps the CoffeeComponent. A decorated coffee object
     * "is-a" Coffee object and it "has-a" Coffee object that it decorates/wraps.
     * @param component Coffee component to decorate
     */
    public CoffeeDecoratorAbstract(Coffee component) {
        this.component = component;
    }
}

