package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema {


    public MapSchema required() {
        addChecks(
                "required",
                value -> value instanceof Map
                        && value != null
        );
        return this;
    }

    public MapSchema sizeof(int sizeValue) {
        addChecks(
                "sizeof",
                value -> ((Map<?, ?>) value).size() == sizeValue
        );
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> schemas) {
        addChecks(
                "shape",
                value -> checkShape((Map) value, schemas)
        );
        return this;
    }


    public boolean checkShape(Map<String, Object> validMap, Map<String, BaseSchema> schemas) {
        for (Map.Entry<String, BaseSchema> schema : schemas.entrySet()) {
            String name = schema.getKey();
            BaseSchema tempSchema = schema.getValue();

            Object tempValue = validMap.get(name);
            if (!tempSchema.isValid(tempValue)) {
                return false;
            }

        }
        return true;


    }
}


