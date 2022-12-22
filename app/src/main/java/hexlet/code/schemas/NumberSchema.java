package hexlet.code.schemas;

public class NumberSchema extends BaseSchema {

    private boolean required = false;
    private boolean positive = false;
    private boolean range = false;
    private int startRange;
    private int endRange;

    public NumberSchema required() {
        required = true;
        return this;
    }

    public NumberSchema positive() {
        positive = true;
        return this;
    }

    public NumberSchema range(int start, int end) {
        this.startRange = start;
        this.endRange = end;
        this.range = true;
        return this;
    }


    @Override
    public boolean valid(Object value) {
        int intValue = 0;

        if (required) {
            if (!(value instanceof Integer) || value == null) {
                return false;
            } else {
                intValue = (int) value;
            }
        }


        if (positive && required) {
            if (intValue <= 0) {
                return false;
            }
        }


        if (range && required) {
            if (intValue < this.startRange || intValue > this.endRange) {
                return false;
            }
        }

        return true;
    }


}
