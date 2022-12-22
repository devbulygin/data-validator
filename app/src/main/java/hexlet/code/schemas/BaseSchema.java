package hexlet.code.schemas;

import java.util.List;
import java.util.Map;

public class BaseSchema {
    private Object value;

    public boolean valid(Object value) {
        return true;
    }

    public boolean isValid(Object value) {
       return valid(value);
    }
}
