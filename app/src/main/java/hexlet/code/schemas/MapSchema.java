package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema {
    private boolean required = false;
    private boolean sizeof = false;
    private int size;

    public MapSchema required() {
        required = true;
        return this;
    }

    public MapSchema sizeof(int sizeValue) {
        this.sizeof = true;
        this.size = sizeValue;
        return this;
    }

    @Override
    public boolean valid(Object value) {

        if (required) {
            if (!(value instanceof Map) || value == null) {
                return false;
            }
        }


        if (sizeof && required) {
            if (((Map<?, ?>) value).size() != size) {
                return false;
            }
        }

        return true;
    }


}
