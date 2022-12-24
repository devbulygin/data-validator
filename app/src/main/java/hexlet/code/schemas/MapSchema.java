package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema {
    private boolean required = false;
    private boolean sizeof = false;
    private boolean shape = false;
    private int size;
    private Map<String, BaseSchema> schemas;


    public MapSchema required() {
        required = true;
        return this;
    }

    public MapSchema sizeof(int sizeValue) {
        this.sizeof = true;
        this.size = sizeValue;
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> schemas1) {
        this.schemas = schemas1;
        this.shape = true;
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

        if (shape) {

            for (Map.Entry<String, BaseSchema> schema : this.schemas.entrySet()) {
                String name = schema.getKey();
                BaseSchema tempSchema = schema.getValue();

                Object tempValue = ((Map<String, Object>) value).get(name);
                if (!tempSchema.isValid(tempValue)) {
                    return false;
                }
            }
            return true;

        }

        return true;
    }


}
