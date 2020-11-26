package nullObject;

import java.util.LinkedList;

public class DefaultOrder implements IOrderer{

    /**
     * This method represents the "null" version of orderer. It will return the data list exactly as it receives it.
     * @param data List to be ordered
     * @return data.
     */
    @Override
    public LinkedList<String> order(LinkedList<String> data) {
        return data;
    }
}
