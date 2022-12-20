package hexlet.code.schemas;

import hexlet.code.Validator;

public class StringSchema extends Validator {
    private boolean valid;
    private boolean required = false;
    private boolean minLength = false;
    private boolean contains = false;


    private int length;

    private String containsValue;


    public StringSchema() {
    }

    public void required() {
        required = true;
    }

    public void minLength(int length) {
        minLength = true;
        this.length = length;
    }

    public void contains(String containsValue) {
        contains = true;
        this.containsValue = containsValue;
    }

    public boolean isValid(Object value) {
        boolean result = true;
        if (required) {
            if (!(value instanceof String) || value.toString().isEmpty() || value.toString().isBlank())
                result = false;
        }


        if (minLength) {
            if (value instanceof String && value.toString().length() >= length)
                result = true;
            else result = false;
        }


        if (contains) {
            if (value instanceof String && value.toString().contains(containsValue))
                result = true;
            else result = false;
        }

        return result;
    }
}
