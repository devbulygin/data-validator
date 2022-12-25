package hexlet.code.schemas;


public final class StringSchema extends BaseSchema {

    private boolean required = false;
    private boolean minLength = false;
    private boolean contains = false;

//    private Map<String, Boolean> checks
//            = Map.of("required", required ,  "minLength",minLength, "contains", contains);


    private int length;

    private String containsValue;


    public StringSchema() {
    }


    public StringSchema required() {
        required = true;
        return this;
    }

    public StringSchema minLength(int lengthValue) {
        minLength = true;
        this.length = lengthValue;
        return this;
    }

    public StringSchema contains(String containsVal) {
        contains = true;
        this.containsValue = containsVal;
        return this;
    }

    @Override
    public boolean valid(Object value) {

        if (required) {
            if (!(value instanceof String) || value.toString().isEmpty() || value.toString().isBlank()) {
                return false;
            }
        }

        if (minLength) {
            if (value.toString().length() < length) {
                return false;
            }
        }

        if (required && contains) {
            if (!value.toString().contains(containsValue)) {
                return false;
            }
        }

        return true;
    }
}
