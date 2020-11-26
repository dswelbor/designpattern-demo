package nullObject;

import java.util.LinkedList;
import java.util.Collections;

public class RandomOrder implements IOrderer {
    /**
     * Method represents the algorithm for having a randomly ordered data list.
     * @param data list to be randomized
     * @return randomized data param.
     */
    @Override
    public LinkedList<String> order(LinkedList<String> data) {
        Collections.shuffle(data);
        return data;
    }
}
