package hexlet.code.schemas;

public abstract class BaseSchema {
    private Object value;
    private boolean required;



    public abstract boolean valid(Object checkValue);

    public final boolean isValid(Object checkValue) {

        return valid(checkValue);
    }
}
