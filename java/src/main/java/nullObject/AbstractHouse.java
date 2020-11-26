package nullObject;

import java.util.Arrays;
import java.util.LinkedList;

public abstract class AbstractHouse {
    protected LinkedList<String> data = new LinkedList<>(Arrays.asList(
            "the malt that lay in",
            "the rat that ate",
            "the cat that killed",
            "the dog that worried",
            "the house that Jack Built"

    ));

    public abstract String recite();


}
