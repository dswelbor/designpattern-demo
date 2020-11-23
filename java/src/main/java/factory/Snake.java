package factory;

import java.util.Arrays;
import java.util.List;

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

    @Override
    public String view() {
        String slitherized = this.slitherize();
        StringBuilder summary = new StringBuilder()
                .append(this.name)
                .append(" is a snake.\n")
                .append(slitherized);
        return summary.toString();
    }

    /**
     * Helper method that adds sss or zzz to snake's description. Sss is applied
     * when the snake is active/awake, zzz when the snake is sleeping/resting.
     * @return slitherized description
     */
    private String slitherize() {
        String hiss;
        // awake
        if (this.restCounter == 0) {
            hiss = "sss";
        }
        // resting
        else {
            hiss = "zzz";
        }
        String[] words = this.description.split(" ");
        int wordCount = words.length;
        int numHisses = Math.max(RandomResult.getInt(wordCount), 5);
        for (int i = 0; i < numHisses; ++i) {
            int randIndex = RandomResult.getInt(wordCount);
            String word = words[randIndex] + hiss;
            words[randIndex] = word;
        }
        return String.join(" ", words);
    }
}
