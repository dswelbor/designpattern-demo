package factory;

public class Snake implements Animal{
    public static final int MIN_REST_TIME = 5;
    public static final int MIN_MOVE_TIME = 3;

    private int slitherSpeed;
    private String name;
    private String description;
    private int restCounter;
    private int moveCounter;

    public Snake(String name, String description, int speed) {
        this.name = name;
        this.description = description;
        this.slitherSpeed = speed;
        this.restCounter = 0;
        this.moveCounter = 0;
    }

    /**
     * Method implements Animal move behavior for snake. Snakes alternate
     * between moving/slithering and resting. More time is spent resting
     * @return
     */
    @Override
    public int move() {
        // Note: this is a great opportunity for the State Pattern
        int moveDistance = 0;
        // active and move time left
        if (this.moveCounter < MIN_MOVE_TIME) {
            ++moveCounter;
            moveDistance = this.slitherSpeed;
        }
        // active and reached fatigue threshold
        else if (this.restCounter == 0) {
            boolean stillMoving = RandomResult.getBoolean();
            // passed check - moves
            if (stillMoving) {
                ++moveCounter;
                moveDistance = this.slitherSpeed;
            }
            // failed check - rests
            else {
                ++restCounter;
                // moveDistance = 0;
            }
        }
        // inactive and rest time left
        else if (this.restCounter < MIN_REST_TIME) {
            ++restCounter;
            //moveDistance = 0;
        }
        // inactive and reached sleep threshold
        else {
            boolean stillResting = RandomResult.getBoolean();
            // passed check - rests
            if(stillResting) {
                ++restCounter;
                //moveDistance = 0;
            }
            // failed check - wakes
            else {
                moveCounter = 1;
                restCounter = 0;
                moveDistance = this.slitherSpeed;
            }
        }

        // results calculated
        return moveDistance;
    }
}
