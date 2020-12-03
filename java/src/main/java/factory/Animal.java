package factory;

/**
 * Simple duck class
 */
public interface Animal {

    /**
     * Returns the movement distance of an animal.
     * @return in fly speed
     */
    public int move();

    /**
     * Returns a description of the animal
     * @return str description of animal
     */
    public String view();

}
