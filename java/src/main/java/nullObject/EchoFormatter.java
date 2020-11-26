package nullObject;

import java.util.LinkedList;

public class EchoFormatter implements IFormatter {
    @Override
    public LinkedList<String> format(LinkedList<String> data) {

        for(int i = 0; i < data.size(); i +=2) {
            data.add(i,data.get(i));
        }

        return data;
    }
}
