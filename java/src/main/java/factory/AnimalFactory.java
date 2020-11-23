package factory;

/**
 * Interface for Animal factory implementations
 */
public interface AnimalFactory {
    /**
     * Creates Animals
     * @return Animal
     */
    public Animal createAnimal();
}
