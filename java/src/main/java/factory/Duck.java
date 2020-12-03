package factory;

/**
 * Duck class is a concrete implementation of the Animal interface
 */
public class Duck implements Animal{

    private int speed;
    private String name;
    private String description;

    /**
     * Parameterized ctor for ducks
     * @param name name of duck
     * @param description description of duck
     * @param moveSpeed int speed of duck
     */
    public Duck(String name, String description, int moveSpeed) {
        this.name = name;
        this.description = description;
        this.speed = moveSpeed;
    }

    /**
     * Method implements the move behavior and returns the distance the duck
     * moved.
     * @return int distance move
     */
    @Override
    public int move() {
        return this.speed;
    }

    /**
     * Method provides the string-based description of the duck when it's
     * view()'ed
     * @return
     */
    @Override
    public String view() {
        StringBuilder summary = new StringBuilder();
        summary.append(this.name).append(" is a duck.\n").append(this.description);
        return summary.toString();
    }
}
