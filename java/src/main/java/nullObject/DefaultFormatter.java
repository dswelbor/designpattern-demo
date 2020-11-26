package nullObject;

import java.util.LinkedList;

public class DefaultFormatter implements IFormatter {
    @Override
    public LinkedList<String> format(LinkedList<String> data) {
        return data;
    }
}
