package hexlet.code.schemas;


public class BaseSchema {
    private Object value;

    public boolean valid(Object checkValue) {
        return true;
    }

    public boolean isValid(Object checkValue) {

        return valid(checkValue);
    }
}
