package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {

    public NumberSchema required() {
        addChecks(
                "required",
                value -> value != null
                        && value instanceof Integer

        );
        return this;
    }


    public NumberSchema positive() {

        addChecks(
                "positive",
                value -> (this.getChecks()).containsKey("required")
                        ? (value != null
                        && value instanceof Integer
                        && (int) value > 0)
                        : (value instanceof Integer
                        && (int) value > 0)
                        || value == null




        );

        return this;
    }


    public NumberSchema range(int start, int end) {
        addChecks(
                "range",
                value -> ((int) value) >= start
                        && ((int) value) <= end
        );
        return this;
    }


}
