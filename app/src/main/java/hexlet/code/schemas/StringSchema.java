package hexlet.code.schemas;


public final class StringSchema extends BaseSchema {


    public StringSchema required() {
        addChecks(
                "required",
                value -> value instanceof String
                        && (!((String) value).isEmpty()
                        || !((String) value).isBlank())
        );
        return this;
    }

    public StringSchema minLength(int lengthValue) {
        addChecks(
                "minLength",
                value -> value != null
                        && ((String) value).length() >= lengthValue
        );
        return this;
    }

    public StringSchema contains(String containsVal) {
        addChecks(
                "contains",
                value -> ((String) value).contains(containsVal)
        );
        return this;
    }
}
