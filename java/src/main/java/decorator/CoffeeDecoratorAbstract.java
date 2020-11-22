package decorator;

public abstract class CoffeeDecoratorAbstract extends Coffee {

    protected Coffee component;

    /**
     * Parameterized ctor wraps the CoffeeComponent
     * @param component
     */
    public CoffeeDecoratorAbstract(Coffee component) {
        this.component = component;
    }
}

