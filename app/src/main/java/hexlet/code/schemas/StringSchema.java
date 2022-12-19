package hexlet.code.schemas;

import hexlet.code.Validator;

public class StringSchema extends Validator {
    private boolean valid;
    private String state = "default";

    private int length;

    private String contains;


    public StringSchema() {
    }

    public void required() {
        state = "required";
    }

    public void minLength(int length) {
        state = "minLength";
        this.length = length;
    }

    public void contains(String contains) {
        state = "contains";
        this.contains = contains;
    }

    public boolean isValid(Object value) {

        switch (state) {
            case ("required"):
                if (!(value instanceof String) || value.toString().isEmpty() || value.toString().isBlank())
                    return false;
                else return true;

            case ("minLength"):
                if (value instanceof String && value.toString().length() >= length)
                    return true;
                else return false;


            case ("contains"):
                if (value instanceof String && value.toString().contains(contains))
                    return true;
                else return false;
            default:
                return true;
        }
    }

}
